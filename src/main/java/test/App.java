/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import br.edu.ifpb.emailsharedpod.Pessoa;
import persistence.PersonDAO;

/**
 *
 * @author magdiel-bruno
 */
public class App {
    public static void main(String[] args) {
        PersonDAO pd = new PersonDAO();
        
        //Pessoa p = new Pessoa();
        //p.setNome("Fernando");
        //p.setEmail("fernandof@gmail.com");
                        
//        if(pd.add(p)) {
//            System.out.println("SALVO!");
//        }
        
        for(Pessoa pessoa : pd.listar()) {
            System.out.println(pessoa);
        }        
    }
}
