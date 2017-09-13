package id.co.telkomsigma.tmf.util.common.io.csv.reader;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Created on 6/7/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * @param <DATA>
 */
public abstract class ACSVReader<DATA> implements ICsvReader<DATA> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ACSVReader.class);

    @Override
    public List<DATA> getListBean(String p_PathFile) {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(p_PathFile));
        } catch (FileNotFoundException e) {
            LOGGER.error("Error reading CSV File "+e.toString());
        }
        ColumnPositionMappingStrategy<DATA> strategy = new ColumnPositionMappingStrategy<DATA>();
        strategy.setType(getBeanClass());
        String[] columns = getColumnMappingNames();
        strategy.setColumnMapping(columns);
        CsvToBean csvToBean = new CsvToBean();
        List<DATA> list = csvToBean.parse(strategy, reader);
        return list;
    }

}
