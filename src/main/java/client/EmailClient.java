/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import br.edu.ifpb.emailsharedpod.Email;
import java.util.Timer;
import persistence.EmailDAO;
import timer.ClientTimer;

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
