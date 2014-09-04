/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import br.edu.ifpb.emailsharedpod.Email;
import br.edu.ifpb.emailsharedpod.Fachada;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.TimerTask;
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
        String response = null;

        if (!emails.isEmpty()) {
            response = "HA EMAIL";
            for (Email email : emails) {
                if (FaultTolerance.pingServer(email.getIpServidor())) {
                    try {
                        long t0 = System.currentTimeMillis();
                        Registry registry = LocateRegistry.getRegistry(email.getIpServidor(), 9999);
                        Fachada fachada = (Fachada) registry.lookup("Fachada");

                        byte[] request = new byte[1024];

                        request[0] = 'B';
                        request[1] = 'A';
                        request[2] = 'L';
                        request[3] = 'D';
                        request[4] = 'E';

                        long tOp = fachada.latencia(request).longValue();

                        long tf = System.currentTimeMillis();
                        long tt = tf - t0;

                        float latencia = tt - tOp;

                        float tBanda = (1024 / (latencia / 2)) * 1000;

                        email.setMensagem(email.getMensagem() + "\nCurrent bandwidth: " + String.valueOf(tBanda));

                        fachada.enviaEmail(email);
                        emailDAO.updateStatusToSentEmailCliente(email.getId());

                    } catch (RemoteException ex) {
                        response = "Servidor indisponível";
                    } catch (NotBoundException ex) {
                        response = "Servidor indisponível";
                    }
                }else{
                    response = "Servidor indisponível ping: "+FaultTolerance.pingServer(email.getIpServidor());
                }
            }
        }else{
            response = "Não há email para ser enviado";
        }
    }
}
