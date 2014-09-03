/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import br.edu.ifpb.emailsharedpod.Email;
import tolerance.FaultTolerance;
import util.EmailUtil;

/**
 *
 * @author magdiel-bruno
 */
public class AppMagdielBruno {
    public static void main(String[] args) {
        Email email = new Email();
        
        email.setAssunto("Porra nenhuma");
        email.setMensagem("Ta saindo do lugar");
        email.setRemetente("Sou eu!");
        email.setDestinatarios("magdiel.ildefonso@gmail.com, fernandodof@gmail.com, kelsonsd@gmail.com");
        
        //EmailUtil.sendEmail(email);
        
        System.out.println(FaultTolerance.ping());
        //System.out.println(FaultTolerance.pingServer("10.1.1.120"));
    }
}
