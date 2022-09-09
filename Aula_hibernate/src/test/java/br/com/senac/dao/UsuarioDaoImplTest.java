/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;
import static br.com.senac.util.Gerador.*;
import java.util.List;

/**
 *
 * @author felipe.ticiani
 */
public class UsuarioDaoImplTest {
    
    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private Session session;
    
    public UsuarioDaoImplTest() {
        usuarioDao = new UsuarioDaoImpl();
    }
    
    public Usuario buscarUsuarioBD() {
        session = HibernateUtil.abrirConexao();
        List<Usuario> usuarios = session.createQuery("from Usuario u").getResultList();
        session.close();
        if (usuarios.isEmpty()) {
            session.save(new Usuario(gerarNome(), gerarLogin(), gerarSenha(10)));
        }
        usuario = usuarios.get(0);
        return usuario;
    }

    @Test
    public void testSalvar() {
        // Arrange
        usuario = new Usuario(gerarNome(), gerarLogin(), gerarSenha(10));
        session = HibernateUtil.abrirConexao();
        
        // Act
        usuarioDao.salvarOuAlterar(usuario, session);
        session.close();
        
        // Assert
        assertNotNull(usuario.getId());
    }
    
    @Test
    public void testPesquisarPorID() {
        // Arrange
        buscarUsuarioBD();
        session = HibernateUtil.abrirConexao();
        
        // Act
        Usuario encontrado = usuarioDao.pesquisarPorID(usuario.getId(), session);
        session.close();
        
        // Assert
        assertEquals(encontrado.getId(), usuario.getId());
        assertEquals(encontrado.getNome(), usuario.getNome());
        assertEquals(encontrado.getLogin(), usuario.getLogin());
    }
    
    @Test
    public void testExcluir() {
        // Arrange
        buscarUsuarioBD();
        session = HibernateUtil.abrirConexao();
        
        // Act
        usuarioDao.excluir(usuario, session);
        Usuario encontrado = usuarioDao.pesquisarPorID(usuario.getId(), session);
        session.close();
        
        // Assert
        assertNull(encontrado);
    }
    
    @Test
    public void testAlterar() {
        // Arrange
        buscarUsuarioBD();
        session = HibernateUtil.abrirConexao();
        usuario.setNome(gerarNome());
        usuarioDao.salvarOuAlterar(usuario, session);
        session.close();
        
        // Act
        session = HibernateUtil.abrirConexao();
        Usuario encontrado = usuarioDao.pesquisarPorID(usuario.getId(), session);
        session.close();
        
        // Assert
        assertEquals(encontrado.getId(), usuario.getId());
        assertEquals(encontrado.getNome(), usuario.getNome());
        assertEquals(encontrado.getLogin(), usuario.getLogin());
    }
    
    @Test
    public void testPesquisarPorNome() {
        // Arrange
        buscarUsuarioBD();
        session = HibernateUtil.abrirConexao();
        
        // Act
        List<Usuario> encontrados = usuarioDao.pesquisarPorNome(usuario.getNome(), session);
        session.close();
        
        // Assert
        assertTrue(encontrados.size() > 0);
        assertEquals(encontrados.get(0).getId(), usuario.getId());
        assertEquals(encontrados.get(0).getNome(), usuario.getNome());
        assertEquals(encontrados.get(0).getLogin(), usuario.getLogin());
    }
    
    @Test
    public void testPesquisarTodos() {
        // Arrange
        buscarUsuarioBD();
        session = HibernateUtil.abrirConexao();
        
        // Act
        List<Usuario> encontrados = usuarioDao.pesquisarTodos(session);
        session.close();
        
        // Assert
        assertTrue(encontrados.size() > 0);
    }
    
    @Test
    public void testLogar() {
        // Arrange
        buscarUsuarioBD();
        session = HibernateUtil.abrirConexao();
        
        // Act
        Usuario encontrado = usuarioDao.logar(session, usuario.getLogin(), usuario.getSenha());
        session.close();
        
        // Assert
        assertNotNull(encontrado);
        assertEquals(encontrado.getId(), usuario.getId());
        assertEquals(encontrado.getSenha(), usuario.getSenha());
        assertEquals(encontrado.getLogin(), usuario.getLogin());
    }
    
}
