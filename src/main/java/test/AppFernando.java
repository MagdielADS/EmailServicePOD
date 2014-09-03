/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import br.edu.ifpb.emailsharedpod.Email;
import java.util.List;
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
        

        List<Email> emails = emailDAO.getUnsentEmailsCliente();
        System.out.println(emails);
//        for (Email email1 : emails) {
//            System.out.println(email1);
//        }

    }
}
