/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.crud.repository;

import br.com.senac.crud.model.User;
import gerador.Gerador;
import java.time.LocalDate;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author felipe.ticiani
 */
public class UserRepositoryTest {
    
    private User user;
    private UserRepository repo;
    
    public UserRepositoryTest() {
        repo = new UserRepository();
    }

    @Test
    public void testSave() throws Exception {
        // Arrange
        user = new User(1L, Gerador.gerarNome(), Gerador.gerarLogin(),
                Gerador.gerarSenha(10), LocalDate.now());
        
        // Act
        repo.save(user);
        User foundUser = repo.findById(user.getId());
        
        // Assert
        assertNotNull(foundUser);
        assertEquals(foundUser.getName(), user.getName());
    }

    @Test
    public void testUpdate() throws Exception {
        // Arrange
        user = new User(1L, Gerador.gerarNome(), Gerador.gerarLogin(),
                Gerador.gerarSenha(10), LocalDate.now());
        repo.save(user);
        
        // Act
        user.setName("New name");
        repo.update(user);
        User foundUser = repo.findById(user.getId());
        
        // Assert
        assertEquals(foundUser.getName(), user.getName());
    }

    @Test
    public void testDelete() throws Exception {
        // Arrange
        user = new User(1L, Gerador.gerarNome(), Gerador.gerarLogin(),
                Gerador.gerarSenha(10), LocalDate.now());
        repo.save(user);
        
        // Act
        repo.delete(user.getId());
        
        // Assert
    }

    @Test
    public void testFindById() throws Exception {
        // Arrange
        
        // Act
        
        // Assert
    }

    @Test
    public void testFindAll() throws Exception {
        // Arrange
        
        // Act
        
        // Assert
    }

    @Test
    public void testFindByName() throws Exception {
        // Arrange
        
        // Act
        
        // Assert
    }
    
}
