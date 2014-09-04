/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import br.edu.ifpb.emailsharedpod.Email;
import br.edu.ifpb.emailsharedpod.Pessoa;
import persistence.PersonDAO;
import tolerance.FaultTolerance;

/**
 *
 * @author magdiel-bruno
 */
public class AppMagdielBruno {
    public static void main(String[] args) {
        Email email = new Email();
        PersonDAO pdb = new PersonDAO();
        
        email.setAssunto("Porra nenhuma");
        email.setMensagem("Ta saindo do lugar");
        email.setRemetente("Sou eu!");
        email.setDestinatarios("magdiel.ildefonso@gmail.com, fernandodof@gmail.com, kelsonsd@gmail.com");
        
        //EmailUtil.sendEmail(email);
        
        Pessoa p = new Pessoa();
        p.setNome("Magdiel");
        p.setEmail("magdiel.ildefonso@gmail.com");
        pdb.add(p);
        p.setNome("Kelson");
        p.setEmail("kelsonsd@gmail.com");
        pdb.add(p);
        
        
        //System.out.println(FaultTolerance.ping());
        //System.out.println(FaultTolerance.pingServer("10.1.1.120"));
    }
}
