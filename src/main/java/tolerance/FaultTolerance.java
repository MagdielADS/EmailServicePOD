/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tolerance;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

/**
 *
 * @author magdiel-bruno
 */
public class FaultTolerance {
    
    public static boolean ping(){
        boolean result = false;
        
        try {
            URL url = new URL("http://smtp.gmail.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            result = true;
        } catch (MalformedURLException e) {
            result = false;
        } catch (IOException ex) {
            result = false;
        }
        
        return result;
    }
    
    public static boolean pingServer(String host){
        boolean result = false;
        try {
            Socket socket = new Socket(host, 9999);
            result = true;
        } catch (IOException ex) {
            result = false;
        }
        return result;
    }
}
