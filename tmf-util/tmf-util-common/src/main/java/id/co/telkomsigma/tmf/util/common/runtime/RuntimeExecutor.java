package id.co.telkomsigma.tmf.util.common.runtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static id.co.telkomsigma.tmf.util.common.constant.TMFUtilCommonConstant.RunTime.*;

/**
 * Created on 7/7/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RuntimeExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(RuntimeExecutor.class);

    public static List<String> findAllJavaProcess() {
        List<String> result = new ArrayList<>();
        String [] COMMAND = {PGREP, _FL, JAVA};
        try {
            String process;
            Process p = Runtime.getRuntime().exec(COMMAND);
            p.waitFor();
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((process = input.readLine()) != null) {
                result.add(process);
            }
            input.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String findPIDofJavaProcess(String p_NameOfJavaProcess) {
        List<String> allJavaProcess = findAllJavaProcess();
        String PID = null;
        for (String jp : allJavaProcess){
            if (jp.contains(p_NameOfJavaProcess)){
                LOGGER.info(jp);
                PID = jp.split(" ")[0];
            }
        }
        return PID;
    }

    public static void killAnotherJavaProcess(String p_NameOfJavaProcess) {
        String PID = findPIDofJavaProcess(p_NameOfJavaProcess);
        if (PID != null){
            final String COMMAND = KILL_SERVICE.concat(PID);
            try {
                Runtime.getRuntime().exec(COMMAND);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                LOGGER.info(p_NameOfJavaProcess.concat(" Has Been Killed!"));
            }
        }

    }

    public static int startSingleProcess(String p_NameOfProcess, String p_Arguments[], String p_BreakIdentifier) {
        String command = RUN_JAVA.concat(p_NameOfProcess);
        String arguments = " ";
        if (p_Arguments.length > 0){
            for (String  args : p_Arguments){
                arguments += args.concat(" ");
            }
        }
        command += arguments.concat(IN_BACKGROUND);
        LOGGER.info("COMMAND "+command);
        try {
            String process;
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((process = input.readLine()) != null) {
                LOGGER.info(process);
                if (process.contains(p_BreakIdentifier))
                    break;
            }
            input.close();
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
