/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.crud.repository;

import br.com.senac.crud.model.Client;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author felipe.ticiani
 */
public class ClientRepository implements IClientRepository {
    private PreparedStatement ps;
    private String sql;
    private Connection db;
    private ResultSet rs;
    
    @Override
    public Long save(Client client) throws SQLException {
        try {
            db = ConnectionFactory.open();
            sql = "INSERT INTO client (name, cpf, rg, salary) VALUES (?, ?, ?, ?)";
            ps = db.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getName());
            ps.setString(2, client.getCpf());
            ps.setString(3, client.getRg());
            ps.setDouble(4, client.getSalary());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            System.out.println("Error on save method.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ps.close();
            db.close();
        }
    }
    
    @Override
    public Client findById(Long id) throws SQLException {
        Client foundClient = new Client();
        try {
            db = ConnectionFactory.open();
            sql = "SELECT * FROM client WHERE id = ?";
            ps = db.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                foundClient.setId(rs.getLong("id"));
                foundClient.setName(rs.getString("name"));
                foundClient.setCpf(rs.getString("cpf"));
                foundClient.setRg(rs.getString("rg"));
                foundClient.setSalary(rs.getDouble("salary"));
            }
            return foundClient;
        } catch (SQLException e) {
            System.out.println("Error on find by id");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ps.close();
            db.close();
        }
    }
    
    @Override
    public Client findByCpf(String cpf) throws SQLException {
        Client foundClient = null;
        try {
            db = ConnectionFactory.open();
            sql = "SELECT * FROM client WHERE cpf = ?";
            ps = db.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                foundClient = new Client();
                foundClient.setId(rs.getLong("id"));
                foundClient.setName(rs.getString("name"));
                foundClient.setCpf(rs.getString("cpf"));
                foundClient.setRg(rs.getString("rg"));
                foundClient.setSalary(rs.getDouble("salary"));
            }
            return foundClient;
        } catch (SQLException e) {
            System.out.println("Error on find by cpf");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ps.close();
            db.close();
        }
    }
    
    @Override
    public void delete(Long id) throws SQLException {
        try {
            db = ConnectionFactory.open();
            sql = "DELETE FROM client WHERE id = ?";
            ps = db.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error on delete method.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ps.close();
            db.close();
        }
    }
    
    @Override
    public void update(Client client) throws SQLException {
        try {
            db = ConnectionFactory.open();
            sql = "UPDATE client SET name = ?, cpf = ?, rg = ?, salary = ? WHERE id = ?";
            ps = db.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getCpf());
            ps.setString(3, client.getRg());
            ps.setDouble(4, client.getSalary());
            ps.setLong(5, client.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error on update method.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(db, ps, rs);
        }
    }
}
