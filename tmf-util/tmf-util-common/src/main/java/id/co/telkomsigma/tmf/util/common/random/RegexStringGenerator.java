package id.co.telkomsigma.tmf.util.common.random;

import com.mifmif.common.regex.Generex;

/**
 * Created on 10/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RegexStringGenerator {

    public static String generateRegex(String p_Regex){
        Generex generex = new Generex(p_Regex);
        return generex.random();
    }

}
