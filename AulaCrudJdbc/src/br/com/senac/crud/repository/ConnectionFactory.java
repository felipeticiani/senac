/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.crud.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author felipe.ticiani
 */
public class ConnectionFactory {
    private static final String TIMEZONE = "?useTimezone=true&serverTimezone=America/Sao_Paulo&zeroDateTimeBehavior=convertToNull";
    private static final String DB_NAME = "";
    private static final String DATABASE = "jdbc:mysql://localhost:3306/" + DB_NAME + TIMEZONE;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Senac2021";
    
    public static Connection open() {
	try {
            // Não é mais necessário a partir do Java 1.6.
            //Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
	} catch(SQLException e) {
            System.out.println("Erro ao abrir conexão.");
            throw new RuntimeException(e);
        }
    }
}
