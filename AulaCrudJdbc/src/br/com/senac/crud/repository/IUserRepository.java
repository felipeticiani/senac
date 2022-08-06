/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.crud.repository;

import br.com.senac.crud.model.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author felipe.ticiani
 */
public interface IUserRepository {
    void save(User newUser) throws SQLException;
    void update(User user) throws SQLException;
    void delete(Long userId) throws SQLException;
    User findById(Long userId) throws SQLException;
    List<User> findAll() throws SQLException;
    List<User> findByName(String name) throws SQLException;
}
