package id.co.telkomsigma.tmf.util.common.io;

import java.io.File;

/**
 * Created on 6/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FileMovement {

    /**
     *
     * @return 1 if success
     */
    public static int moveFile(String p_SourcePath, String p_DestinationPath){
        File sourceFile =new File(p_SourcePath);
        if(sourceFile.renameTo(new File(p_DestinationPath + sourceFile.getName()))){
            return 1;
        }else{
            return 0;
        }
    }
}
