/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.DBConnection;

/**
 *
 * @author magdiel-bruno
 */
public class App {
    public static void main(String[] args) {
        try {
            DBConnection.getInstance().getConnection();
            System.out.println("OK");
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
