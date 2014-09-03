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
import java.util.ArrayList;
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
        
        
        return result;
    }

    @Override
    public void salvar(Pessoa pessoa) throws RemoteException {
        PersonDAO pdb = new PersonDAO();
        pdb.add(pessoa);
    }

    @Override
    public List<Pessoa> listaPessoas() throws RemoteException {
        List<Pessoa> persons = new ArrayList<Pessoa>();
        PersonDAO pdb = new PersonDAO();
        persons = pdb.listar();
        return persons;
    }
}
