/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import br.edu.ifpb.emailsharedpod.Email;
import br.edu.ifpb.emailsharedpod.Fachada;
import br.edu.ifpb.emailsharedpod.Pessoa;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import persistence.PersonDAO;

/**
 *
 * @author magdiel-bruno
 */
public class EmailServer implements Fachada{ 

    @Override
    public String enviaEmail(Email email) throws RemoteException {
        String result = "Email não enviado, aguarde tentaremos reestabelecer a conexão";
        
        final String from = "ifpbpod@gmail.com";
        final String pass = "rmi12345";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, pass);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getRemetente()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email.getDestinatarios()));
            message.setSubject(email.getAssunto());
            message.setText(email.getMensagem());

            Transport.send(message);
            
            result = "Email enviado com sucesso";

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void salvar(Pessoa pessoa) throws RemoteException {
        new PersonDAO().add(pessoa);
    }

    @Override
    public List<Pessoa> listaPessoas() throws RemoteException {
        return new PersonDAO().listar();
    }
}
