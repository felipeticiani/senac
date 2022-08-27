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
}
