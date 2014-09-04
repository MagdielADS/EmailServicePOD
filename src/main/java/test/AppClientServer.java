/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import Server.EmailServer;
import client.EmailClient;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author magdiel-bruno
 */
public class AppClientServer {
    public static void main(String[] args) {
        try {
            EmailServer es = new EmailServer();
        } catch (RemoteException ex) {
            Logger.getLogger(AppClientServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        EmailClient ec = new EmailClient();
    }
}
