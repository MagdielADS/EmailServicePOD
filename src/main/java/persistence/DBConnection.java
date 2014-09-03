/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author magdiel-bruno
 */
public class DBConnection {
    private static DBConnection instance;
    private final String url;
    private final String usuario;
    private final String senha;

    //Verifiquem sua senha e login do postgres
    private DBConnection() {
        this.url = "jdbc:postgresql://localhost:5432/pod";
        this.usuario = "postgres";
        this.senha = "123456";
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException("Problems Initializing database");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return connection;
    }
}
