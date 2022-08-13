/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.crud.repository;

import br.com.senac.crud.model.User;
import gerador.Gerador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author felipe.ticiani
 */
public class UserRepositoryTest {
    
    private User user;
    private UserRepository repo;
    String login;
    
    public UserRepositoryTest() {
        login = "sarah.silva";
        repo = new UserRepository();
    }
    
    private User getUserOnDB() throws Exception {
        User foundUser = null;
        Connection db = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            db = ConnectionFactory.open();
            String sql = "SELECT * FROM user";
            ps = db.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                foundUser =  new User();
                foundUser.setId(rs.getLong("id"));
                foundUser.setName(rs.getString("name"));
                foundUser.setLogin(rs.getString("login"));
                foundUser.setPassword(rs.getString("password"));
                Date dbDate = rs.getDate("last_access");
                foundUser.setLastAccess(dbDate.toLocalDate());
            } else {
                testSave();
            }
            return foundUser;
        } catch (SQLException e) {
            System.out.println("Error on getUserOnDB");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(db, ps, rs);
        }
    }

    @Test
    public void testSave() throws Exception {
        // Arrange
        repo.delete(repo.findByLogin(login).getId());
        user = new User(null, Gerador.gerarNome(), login,
                Gerador.gerarSenha(10), LocalDate.now());
        
        // Act
        Long idGerado =  repo.save(user);
        User foundUser = repo.findById(idGerado);
        
        // Assert
        assertEquals(foundUser.getName(), user.getName());
        assertEquals(foundUser.getLogin(), user.getLogin());
        assertEquals(foundUser.getPassword(), user.getPassword());
        assertEquals(foundUser.getLastAccess(), user.getLastAccess());
    }

    @Test
    public void testUpdate() throws Exception {
        // Arrange
        user = new User(null, Gerador.gerarNome(), login,
                Gerador.gerarSenha(10), LocalDate.now());
        repo.save(user);
        user = repo.findByLogin(login);
        
        // Act
        user.setName(Gerador.gerarNome());
        repo.update(user);
        User foundUser = repo.findByLogin(login);
        
        // Assert
        assertEquals(foundUser.getName(), user.getName());
        assertEquals(foundUser.getLogin(), user.getLogin());
        assertEquals(foundUser.getPassword(), user.getPassword());
        assertEquals(foundUser.getLastAccess(), user.getLastAccess());
    }

    @Test
    public void testDelete() throws Exception {
        // Arrange
        user = repo.findByLogin(login);
        
        // Act
        repo.delete(user.getId());
        
        // Assert
        
    }

    @Test
    public void testFindById() throws Exception {
        // Arrange
        User savedUser = getUserOnDB();
        // Act
        User foundUser = repo.findById(savedUser.getId());
        // Assert
        assertEquals(savedUser.getId(), foundUser.getId());
        assertEquals(savedUser.getName(), foundUser.getName());
        assertEquals(savedUser.getLogin(), foundUser.getLogin());
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
