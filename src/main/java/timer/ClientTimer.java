/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import br.edu.ifpb.emailsharedpod.Email;
import br.edu.ifpb.emailsharedpod.Fachada;
import client.EmailClient;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.EmailDAO;
import tolerance.FaultTolerance;

/**
 *
 * @author Fernando
 */
public class ClientTimer extends TimerTask {

    @Override
    public void run() {
        EmailDAO emailDAO = new EmailDAO();
        List<Email> emails = emailDAO.getUnsentEmailsCliente();

        if (!emails.isEmpty()) {
            for (Email email : emails) {
                if (FaultTolerance.pingServer(email.getIpServidor())) {
                    try {
                        Registry registry = LocateRegistry.getRegistry(email.getIpServidor());
                        Fachada fachada = (Fachada) registry.lookup("Fachada");
                        fachada.enviaEmail(email);
                        emailDAO.updateStatusToSentEmailCliente(email.getId());

                    } catch (RemoteException ex) {
                        Logger.getLogger(EmailClient.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NotBoundException ex) {
                        Logger.getLogger(EmailClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

}
