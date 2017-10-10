package id.co.telkomsigma.tmf.util.common.io.csv.generator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * created on 11/30/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CSVGenerator {

    public void generateFile(String p_FileNameTarget, List<List<String>> p_Data) {
        try {
            FileWriter writer = new FileWriter(p_FileNameTarget);
            for(List<String > data : p_Data){
                CSVWriter.writeLine(writer, data);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
