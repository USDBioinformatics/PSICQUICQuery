/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psicquic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import javax.xml.stream.XMLStreamException;


/**
 *
 * @author Mathialakan.Thavappi
 */
public class WebData {

    public static String getString(String url) {
        String content = "";
        try {
            InputStream is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String line;
            while ((line = rd.readLine()) != null) {
                content += "\n" + line;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return content;
    }
public ArrayList<String> getStringList(String url) {
        ArrayList<String> content = new ArrayList<String>();
        try {
            InputStream is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String line;
            while ((line = rd.readLine()) != null) {
                line = line.trim();
                if (!line.equals("")) {
                    content.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return content;
    }

 
}
