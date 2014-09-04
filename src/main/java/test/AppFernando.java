/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import br.edu.ifpb.emailsharedpod.Email;
import br.edu.ifpb.emailsharedpod.Fachada;
import br.edu.ifpb.emailsharedpod.Pessoa;
import client.EmailClient;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.EmailDAO;
import persistence.PersonDAO;

/**
 *
 * @author Fernando
 */
public class AppFernando {

    public static void main(String[] args) {

        EmailDAO emailDAO = new EmailDAO();
        PersonDAO personDAO = new PersonDAO();
//        Email email = new Email();
//        email.setMensagem("Mensagem");
//        email.setRemetente("Remetente");
//        email.setDestinatarios("1,2,3,4,5");
//        email.setAssunto("Assunto");
//        email.setIpServidor("localhost");
//        email.setStatus(false);
//        emailDAO.save(email);
//        
//
//        List<Email> emails = emailDAO.getUnsentEmailsCliente();
//        System.out.println(emails);
//        for (Email email1 : emails) {
//            System.out.println(email1);
//        }

//            Pessoa pessoa = new Pessoa();
//            pessoa.setEmail("Fernando");
//            pessoa.setNome("fernandodof@gmail.com");
//            fachada.salvar(pessoa);

//            List<Pessoa> pessoas = fachada.listaPessoas();
//            for (Pessoa pessoa : pessoas) {
//                System.out.println(pessoa);
//            }

        Registry registry;
//        try {
//            registry = LocateRegistry.getRegistry("192.168.0.102", 9999);
//            Fachada fachada = (Fachada) registry.lookup("Fachada");
            
            for (int i = 0; i < 15; i++) {
                Pessoa p = new Pessoa();
                p.setNome("Pessoa"+i);
                p.setEmail("pessoa"+i+"@gmail.com");
                
                personDAO.add(p);
//                fachada.salvar(p);
                
//                Email e = new Email();
//                e.setAssunto("Teste de extresse3");
//                e.setDestinatarios("magdiel.ildefonso@gmail.com"+i);
//                e.setIpServidor("192.168.0.102");
//                e.setMensagem("Ta chegando "+i);
//                e.setRemetente("Magdiel");
//                e.setStatus(false);
//                emailDAO.saveCliente(e);
            }
            
//            List<Pessoa> pessoas = fachada.listaPessoas();
//            
//            for (Pessoa pessoa : pessoas) {
//                System.out.println(pessoa.getId()+" - "+pessoa.getEmail());
//            }
            
//        } catch (RemoteException ex) {
//            Logger.getLogger(AppFernando.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NotBoundException ex) {
//            Logger.getLogger(AppFernando.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
        //emailClient.sendEmail(email);

    }
}