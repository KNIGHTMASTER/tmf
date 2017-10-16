package id.co.telkomsigma.tmf.service.crud;

import id.co.telkomsigma.tmf.service.exception.ServiceException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 10/16/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
public interface ICrudTransactionService<DATA, ID> {

    @Transactional
    void insert(DATA p_DATA) throws ServiceException;

    @Transactional
    void flush() throws ServiceException;

    @Transactional
    void insertAndFlush(DATA p_DATA) throws ServiceException;

    @Transactional
    void insertCollection(List<DATA> p_DATA)  throws ServiceException;

    @Transactional
    void update(DATA p_DATA)  throws ServiceException;

    @Transactional
    void delete(ID p_ID)  throws ServiceException;

    @Transactional
    void deleteByEntity(String p_Code)  throws ServiceException;

    @Transactional
    void deleteCollection(List<String> p_Codes)  throws ServiceException;

    @Transactional
    void deleteCollectionById(List<ID> p_ID)  throws ServiceException;
}
