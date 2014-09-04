/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import br.edu.ifpb.emailsharedpod.Email;
import br.edu.ifpb.emailsharedpod.Fachada;
import br.edu.ifpb.emailsharedpod.Pessoa;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.EmailDAO;
import persistence.PersonDAO;
import timer.ServerTimer;

/**
 *
 * @author magdiel-bruno
 */
public class EmailServer extends UnicastRemoteObject implements Fachada {

    public EmailServer() throws RemoteException {
        super();
    }

    @Override
    public String enviaEmail(Email email) throws RemoteException {
        new EmailDAO().save(email);
        return "Your email has been received and eventually will be sent";
    }

    @Override
    public void salvar(Pessoa pessoa) throws RemoteException {
        new PersonDAO().add(pessoa);
    }

    @Override
    public List<Pessoa> listaPessoas() throws RemoteException {
        return new PersonDAO().listar();
    }
    
    @Override
    public Long latencia(byte[] array) {
        long tempo1 = System.currentTimeMillis();
        System.out.println(array);
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            return null;
        }
        long tempo2 = System.currentTimeMillis();
        return tempo2-tempo1;
    }

    public static void main(String[] args) throws AlreadyBoundException {
        Registry registry;
        Timer timer = new Timer();

        try {
            registry = LocateRegistry.createRegistry(9999);
            registry.bind("Fachada", new EmailServer());
        } catch (RemoteException ex) {
            Logger.getLogger(EmailServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        timer.schedule(new ServerTimer(), 0, 10 * 60);
    }
}
