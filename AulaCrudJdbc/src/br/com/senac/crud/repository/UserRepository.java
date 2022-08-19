/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.crud.repository;

import br.com.senac.crud.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipe.ticiani
 */
public class UserRepository implements IUserRepository {
    private PreparedStatement ps;
    private String sql;
    private Connection db;
    private ResultSet rs;

    @Override
    public Long save(User newUser) throws SQLException {
        try {
            db = ConnectionFactory.open();
            sql = "INSERT INTO user (name, login, password, last_access) VALUES (?, ?, ?, ?)";
            ps = db.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, newUser.getName());
            ps.setString(2, newUser.getLogin());
            ps.setString(3, newUser.getPassword());
            ps.setDate(4, Date.valueOf(LocalDate.now()));
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            System.out.println("Error on save method.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(db, ps, rs);
        }
    }

    @Override
    public void update(User user) throws SQLException {
        try {
            db = ConnectionFactory.open();
            sql = "UPDATE user SET name = ?, login = ?, password = ?, last_access = ? WHERE id = ?";
            ps = db.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setDate(4, Date.valueOf(user.getLastAccess()));
            ps.setLong(5, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error on update method.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(db, ps, rs);
        }
    }

    @Override
    public void delete(Long userId) throws SQLException {
        try {
            db = ConnectionFactory.open();
            ps = db.prepareStatement("DELETE FROM user WHERE id = ?");
            ps.setLong(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error on delete method.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(db, ps, rs);
        }
    }

    @Override
    public User findById(Long userId) throws SQLException {
        User foundUser = null;
        try {
            db = ConnectionFactory.open();
            sql = "SELECT * FROM user WHERE id = ?";
            ps = db.prepareStatement(sql);
            ps.setLong(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                foundUser =  new User();
                foundUser.setId(userId);
                foundUser.setName(rs.getString("name"));
                foundUser.setLogin(rs.getString("login"));
                foundUser.setPassword(rs.getString("password"));
                Date dbDate = rs.getDate("last_access");
                foundUser.setLastAccess(dbDate.toLocalDate());
            }
            return foundUser;
        } catch (SQLException e) {
            System.out.println("Error on find by id");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(db, ps, rs);
        }
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> foundUsers = new ArrayList<>();
        try {
            db = ConnectionFactory.open();
            sql = "SELECT * FROM user";
            ps = db.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                foundUsers.add(new User(rs.getLong("id"), rs.getString("name"), rs.getString("login"), 
                        rs.getString("password"), rs.getDate("last_access").toLocalDate()));
            }
            return foundUsers;
        } catch (SQLException e) {
            System.out.println("Error on find all.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(db, ps, rs);
        }
    }

    @Override
    public List<User> findByName(String name) throws SQLException {
        List<User> foundUsers = new ArrayList<>();
        try {
            db = ConnectionFactory.open();
            sql = "SELECT * FROM user WHERE name LIKE ?";
            ps = db.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                foundUsers.add(new User(rs.getLong("id"), rs.getString("name"), rs.getString("login"), 
                        rs.getString("password"), rs.getDate("last_access").toLocalDate()));
            }
            return foundUsers;
        } catch (SQLException e) {
            System.out.println("Error on find by name.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(db, ps, rs);
        }
    }
    
    @Override
    public User findByLogin(String login) throws SQLException {
        User foundUser = null;
        try {
            db = ConnectionFactory.open();
            sql = "SELECT * FROM user WHERE login = ?";
            ps = db.prepareStatement(sql);
            ps.setString(1, login);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                foundUser = new User();
                foundUser.setId(rs.getLong("id"));
                foundUser.setName(rs.getString("name"));
                foundUser.setLogin(rs.getString("login"));
                foundUser.setPassword(rs.getString("password"));
                Date dbDate = rs.getDate("last_access");
                foundUser.setLastAccess(dbDate.toLocalDate());
            }
            return foundUser;
        } catch (SQLException e) {
            System.out.println("Error on find by login");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(db, ps, rs);
        }
    }
}
