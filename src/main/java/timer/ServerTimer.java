/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import br.edu.ifpb.emailsharedpod.Email;
import java.util.List;
import java.util.TimerTask;
import persistence.EmailDAO;
import tolerance.FaultTolerance;
import util.EmailUtil;

/**
 *
 * @author magdiel-bruno
 */
public class ServerTimer extends TimerTask {

    @Override
    public void run() {
        EmailDAO edb = new EmailDAO();
        List<Email> emails = edb.getUnsentEmails();
        
        if(FaultTolerance.ping()){
            for (Email email : emails) {
               if(EmailUtil.sendEmail(email)){
                   edb.updateStatusToSent(email.getId());
               }
            }
        }
    }
}
