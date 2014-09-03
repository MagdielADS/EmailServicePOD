/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import br.edu.ifpb.emailsharedpod.Email;
import br.edu.ifpb.emailsharedpod.Fachada;
import br.edu.ifpb.emailsharedpod.Pessoa;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.EmailDAO;
import timer.ClientTimer;
import tolerance.FaultTolerance;

/**
 *
 * @author magdiel-bruno
 */
public class EmailClient {
    
    public void sendEmail(Email email){
        new EmailDAO().saveCliente(email);
    }
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new ClientTimer(), 0, 500*60);
    }
   
    
}
