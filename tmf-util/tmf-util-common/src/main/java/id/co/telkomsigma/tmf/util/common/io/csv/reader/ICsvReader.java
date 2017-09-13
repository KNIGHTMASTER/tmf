package id.co.telkomsigma.tmf.util.common.io.csv.reader;

import java.util.List;

/**
 * created on 12/2/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public interface ICsvReader<DATA> {

    String [] getColumnMappingNames();

    Class<DATA> getBeanClass();

    List<DATA> getListBean(String p_PathFile);
}
