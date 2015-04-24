/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psicquic;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Mathialakan
 */
public class Psicquic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Psicquic p = new Psicquic();
        String content = p.getByREST("APID", "interactor", "P00533");
        //String content = p.getByREST("GeneMANIA", "interactor", "P00533");
        String fname = "test.txt";
        if (p.writeString(content, fname)) {
            System.out.println("done! ");
        }
    }

    private String getByREST(String db, String method, String query) {
        String url = new URL(db, method, query).generate();
        if (url.equals("")) {
            return "";
        } else {
            return WebData.getString(url);
        }
    }

    private boolean writeString(String content, String fname) {
        FileWriter fw;
        try {
            fw = new FileWriter(fname);
            fw.write(content);
            fw.close();
        } catch (IOException ie) {
            ie.printStackTrace();
            return false;
        }
        return true;
    }
}
