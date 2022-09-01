package br.senac.avaliacao1.repository;

import br.senac.avaliacao1.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipe.ticiani
 */
public class ProdutoRepository implements IProdutoRepository {
    private PreparedStatement ps;
    private String sql;
    private Connection db;
    private ResultSet rs;

    @Override
    public Integer salvar(Produto produto) throws SQLException {
        try {
            db = FabricaConexao.abrirConexao();
            sql = "INSERT INTO produto (nome, descricao, estoque, preco) VALUES (?, ?, ?, ?)";
            ps = db.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setInt(3, produto.getEstoque());
            ps.setDouble(4, produto.getPreco());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("Erro no método salvar.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fecharConexao(db, ps, rs);
        }
    }

    @Override
    public void alterar(Produto produto) throws SQLException {
        try {
            db = FabricaConexao.abrirConexao();
            sql = "UPDATE produto SET nome = ?, descricao = ?, estoque = ?, preco = ? WHERE id = ?";
            ps = db.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setInt(3, produto.getEstoque());
            ps.setDouble(4, produto.getPreco());
            ps.setInt(5, produto.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro no método alterar.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fecharConexao(db, ps, rs);
        }
    }

    @Override
    public void excluir(Integer id) throws SQLException {
        try {
            db = FabricaConexao.abrirConexao();
            sql = "DELETE FROM produto WHERE id = ?";
            ps = db.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro no método excluir.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fecharConexao(db, ps, rs);
        }
    }

    @Override
    public List<Produto> pesquisarPorNome(String nome) throws SQLException {
        try {
            List<Produto> produtosEncontrados = new ArrayList();
            db = FabricaConexao.abrirConexao();
            sql = "SELECT * FROM produto WHERE nome LIKE ?";
            ps = db.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Produto produtoEncontrado = new Produto();
                produtoEncontrado.setId(rs.getInt("id"));
                produtoEncontrado.setNome(rs.getString("nome"));
                produtoEncontrado.setDescricao(rs.getString("descricao"));
                produtoEncontrado.setEstoque(rs.getInt("estoque"));
                produtoEncontrado.setPreco(rs.getDouble("preco"));
                produtosEncontrados.add(produtoEncontrado);
            }
            return produtosEncontrados;
        } catch (SQLException e) {
            System.out.println("Erro no método pesquisar por nome.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fecharConexao(db, ps, rs);
        }
    }

    @Override
    public Produto pesquisarPorId(Integer id) throws SQLException {
        try {
            db = FabricaConexao.abrirConexao();
            sql = "SELECT * FROM produto WHERE id = ?";
            ps = db.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Produto produtoEncontrado = new Produto();
                produtoEncontrado.setId(rs.getInt("id"));
                produtoEncontrado.setNome(rs.getString("nome"));
                produtoEncontrado.setDescricao(rs.getString("descricao"));
                produtoEncontrado.setEstoque(rs.getInt("estoque"));
                produtoEncontrado.setPreco(rs.getDouble("preco"));
                return produtoEncontrado;
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Erro no método pesquisar por id.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fecharConexao(db, ps, rs);
        }
    }

    @Override
    public void excluirTodos() throws SQLException {
        try {
            db = FabricaConexao.abrirConexao();
            sql = "DELETE FROM produto";
            ps = db.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro no método excluir todos.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fecharConexao(db, ps, rs);
        }
    }
    
}
