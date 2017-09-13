package id.co.telkomsigma.tmf.util.common.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created on 7/7/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TestProg {

    public static void main(String args[]){
        try {
            String process;
            String command = "jps -l";
            Process p = Runtime.getRuntime().exec(command);
            String pid = null;
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((process = input.readLine()) != null) {
                if (process.contains("daemon-1.0.0.jar")){
                    System.out.println(process.split(" ")[0]);
                    pid = process.split(" ")[0];
                }
            }
            p = Runtime.getRuntime().exec("kill -9 "+pid);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
