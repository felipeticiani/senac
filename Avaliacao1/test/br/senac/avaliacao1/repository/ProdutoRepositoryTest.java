package br.senac.avaliacao1.repository;

import br.senac.avaliacao1.model.Produto;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author felipe.ticiani
 */
public class ProdutoRepositoryTest {
    private Produto produto;
    private IProdutoRepository repo;
    
    public ProdutoRepositoryTest() {
        repo = new ProdutoRepository();
        produto = new Produto(
        "Escada",
        "Escada que suporta até 120kg",
        250,
        180.5);
    }

    @Test
    public void testSalvar() throws Exception {
        Integer idGerado = repo.salvar(produto);
        Produto produtoEncontrado = repo.pesquisarPorId(idGerado);
        
        assertNotNull(produtoEncontrado.getId());
        assertEquals(produto.getNome(), produtoEncontrado.getNome());
        assertEquals(produto.getDescricao(), produtoEncontrado.getDescricao());
        assertEquals(produto.getEstoque(), produtoEncontrado.getEstoque());
        assertThat(produto.getPreco(), equalTo(produtoEncontrado.getPreco()));
        repo.excluir(idGerado);
    }

    @Test
    public void testAlterar() throws Exception {
        Integer idGerado = repo.salvar(produto);
        
        produto.setId(idGerado);
        produto.setNome("Escada de alumínio");
        produto.setDescricao("Escada de alumínio que suporta até 150kg.");
        produto.setEstoque(50);
        produto.setPreco(239.99);
        repo.alterar(produto);
        Produto produtoEncontrado = repo.pesquisarPorId(idGerado);
        
        assertEquals(idGerado, produtoEncontrado.getId());
        assertEquals(produto.getNome(), produtoEncontrado.getNome());
        assertEquals(produto.getDescricao(), produtoEncontrado.getDescricao());
        assertEquals(produto.getEstoque(), produtoEncontrado.getEstoque());
        assertThat(produto.getPreco(), equalTo(produtoEncontrado.getPreco()));
        repo.excluir(idGerado);
    }

    @Test
    public void testExcluir() throws Exception {
        Integer idGerado = repo.salvar(produto);
        
        repo.excluir(idGerado);
        Produto produtoEncontrado = repo.pesquisarPorId(idGerado);
        
        assertNull(produtoEncontrado);
    }

    @Test
    public void testPesquisarPorNome() throws Exception {
        repo.excluirTodos();
        produto.setNome("Escada de alumínio");
        Integer idGerado = repo.salvar(produto);
        Produto produto2 = new Produto(
        "Escada de mandeira",
        "Escada de madeira pinus que suporta até 70kg.",
        60,
        79.98);
        Integer idGerado2 = repo.salvar(produto2);
        
        List<Produto> produtosEncontrados = repo.pesquisarPorNome("escada");
        
        assertEquals(produtosEncontrados.size(), 2);
        assertNotNull(produtosEncontrados.get(0).getId());
        assertEquals(produto.getNome(), produtosEncontrados.get(0).getNome());
        assertEquals(produto.getDescricao(), produtosEncontrados.get(0).getDescricao());
        assertEquals(produto.getEstoque(), produtosEncontrados.get(0).getEstoque());
        assertThat(produto.getPreco(), equalTo(produtosEncontrados.get(0).getPreco()));
        repo.excluir(idGerado);
        repo.excluir(idGerado2);
    }

    @Test
    public void testPesquisarPorId() throws Exception {
        Integer idGerado = repo.salvar(produto);
        
        Produto produtoEncontrado = repo.pesquisarPorId(idGerado);
        
        assertNotNull(produtoEncontrado.getId());
        assertEquals(produto.getNome(), produtoEncontrado.getNome());
        assertEquals(produto.getDescricao(), produtoEncontrado.getDescricao());
        assertEquals(produto.getEstoque(), produtoEncontrado.getEstoque());
        assertThat(produto.getPreco(), equalTo(produtoEncontrado.getPreco()));
        repo.excluir(idGerado);
    }
    
    @Test
    public void testExcluirTodos() throws Exception {
        repo.salvar(produto);
        
        repo.excluirTodos();
        List<Produto> produtosEncontrados = repo.pesquisarPorNome("");
        
        assertTrue(produtosEncontrados.isEmpty());
    }
    
}
