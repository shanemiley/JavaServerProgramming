/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cookies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Shane miley 
 */
public class CookieJar {
    private String line;
    private ArrayList<String> cookie = new ArrayList<>();

    public String getCookie() {
        Random r = new Random();
        int rand = r.nextInt(cookie.size());
        return cookie.get(rand);
    }

    public CookieJar() throws IOException {
    URL url;
    InputStream is = null;
    BufferedReader br;
 
        try {
            url = new URL("http://fortunes.cat-v.org/openbsd/");
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));
            StringBuilder myStringBuilder = new StringBuilder();
            
            while ((line = br.readLine()) != null) {
                
                if(line.startsWith("</pre>"))break;
                   
                else if(line.startsWith("%")){
                   cookie.add(myStringBuilder.toString());
                   myStringBuilder = new StringBuilder();
                } else {
                    myStringBuilder.append(line);
                    myStringBuilder.append("\n");
                }               
            }
           
        } catch (MalformedURLException mue) {
             mue.printStackTrace();
        } catch (IOException ioe) {
             ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
    }
  
}

