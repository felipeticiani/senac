/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Perfil;
import br.com.senac.entidade.Usuario;
import static br.com.senac.util.Gerador.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author silvio.junior
 */
public class UsuarioDaoImplTest {

    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private Session sessao;

    public UsuarioDaoImplTest() {
        usuarioDao = new UsuarioDaoImpl();
    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.excluir(usuario, sessao);

        Usuario usuExc = usuarioDao
                .pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        assertNull(usuExc);
    }

//    @Test
    public void testSalvar() {
        System.out.println("salvar");
        
        PerfilDaoImplTest pdit = new PerfilDaoImplTest();
        Perfil perfil = pdit.buscarPerfilBD();
        
        usuario = new Usuario(gerarNome(), (gerarLogin()
                + gerarSenha(4)), gerarSenha(8));
        usuario.setPerfil(perfil);
        
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.salvarOuAlterar(usuario, sessao);
        sessao.close();
        assertNotNull(usuario.getId());
    }

//    @Test
    public void testAlterar() {
        System.out.println("alterar");
        buscarUsuarioBd();
        usuario.setNome(gerarNome());
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.salvarOuAlterar(usuario, sessao);
        sessao.close();

        sessao = HibernateUtil.abrirConexao();
        Usuario usuarioPesq = usuarioDao
                .pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        assertEquals(usuarioPesq.getNome(), usuario.getNome());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        Usuario usuarioPesq = usuarioDao
                .pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        assertNotNull(usuarioPesq);
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        List<Usuario> usuarios = usuarioDao
               .pesquisarPorNome(usuario.getNome(), sessao);
        sessao.close();
        assertTrue(usuarios.size() > 0);
        
    }
    
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        List<Usuario> usuarios = usuarioDao
                                .pesquisarTodos(sessao);
        sessao.close();
        mostrar(usuarios);
        assertTrue(!usuarios.isEmpty());
    }

    private void mostrar(List<Usuario> usuarios) {
        
        usuarios.stream()                
                .forEach(usu ->{
            System.out.println("ID " + usu.getId());
            System.out.println("Nome " + usu.getNome());
            System.out.println("Login " + usu.getLogin());
            System.out.println("Senha " + usu.getSenha());
            System.out.println("");
        });
    }
    
    private void mostrarSorted(List<Usuario> usuarios) {
        usuarios.stream()
                .sorted( (usu1, us2) -> 
                      usu1.getNome().compareTo(us2.getNome()))
                .forEach(usu ->{
            System.out.println("ID " + usu.getId());
            System.out.println("Nome " + usu.getNome());
            System.out.println("Login " + usu.getLogin());
            System.out.println("Senha " + usu.getSenha());
            System.out.println("");
        });
    }
    
    
    
//    @Test
    public void testLogar() {
        System.out.println("logar");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        Usuario usuarioLogado = usuarioDao
      .logar(usuario.getLogin(), usuario.getSenha(), sessao);
        sessao.close();
        assertNotNull(usuarioLogado);
                
    }

    public Usuario buscarUsuarioBd() {
        sessao = HibernateUtil.abrirConexao();
        Query<Usuario> consulta = sessao
                .createQuery("from Usuario u"); //HQL
        List<Usuario> usuarios = consulta.getResultList();
        sessao.close();
        if (usuarios.isEmpty()) {
            testSalvar();
        } else {
            usuario = usuarios.get(0);
        }
        return usuario;
    }

    

}
