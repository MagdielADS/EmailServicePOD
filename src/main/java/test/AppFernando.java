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
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.EmailDAO;

/**
 *
 * @author Fernando
 */
public class AppFernando {

    public static void main(String[] args) {

        EmailDAO emailDAO = new EmailDAO();
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
        Email email = new Email();
        email.setMensagem("Mensagem");
        email.setRemetente("Remetente");
        email.setDestinatarios("magdiel.ildefonso@gmail.com, fernandodof@gmail.com");
        email.setAssunto("E agora?");
        email.setIpServidor("10.1.1.112");
        email.setStatus(false);
        EmailClient emailClient = new EmailClient();
        emailClient.sendEmail(email);

    }
}