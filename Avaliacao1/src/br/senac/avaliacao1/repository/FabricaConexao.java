package br.senac.avaliacao1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author felipe.ticiani
 */
public class FabricaConexao {
    private static final String TIMEZONE = "?useTimezone=true&serverTimezone=America/Sao_Paulo&zeroDateTimeBehavior=convertToNull";
    private static final String DB_NAME = "desktop_avaliacao1";
    private static final String DATABASE = "jdbc:mysql://localhost:3306/" + DB_NAME + TIMEZONE;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Senac2021";
    
    public static Connection abrirConexao() {
	try {
            // Não é mais necessário a partir do Java 1.6.
            //Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
	} catch(SQLException e) {
            System.out.println("Erro ao abrir conexão.");
            throw new RuntimeException(e);
        }
    }
    
    public static void fecharConexao(Connection db, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null) rs.close();
        ps.close();
        db.close();
    }
}
