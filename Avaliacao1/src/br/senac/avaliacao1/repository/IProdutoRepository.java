package br.senac.avaliacao1.repository;

import br.senac.avaliacao1.model.Produto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author felipe.ticiani
 */
public interface IProdutoRepository {
    Integer salvar(Produto produto) throws SQLException;
    void alterar(Produto produto) throws SQLException;
    void excluir(Integer id) throws SQLException;
    List<Produto> pesquisarPorNome(String nome) throws SQLException;
    Produto pesquisarPorId(Integer id) throws SQLException;
    void excluirTodos() throws SQLException;
}
