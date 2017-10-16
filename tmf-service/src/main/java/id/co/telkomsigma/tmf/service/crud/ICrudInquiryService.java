package id.co.telkomsigma.tmf.service.crud;

import id.co.telkomsigma.tmf.service.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created on 10/16/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
public interface ICrudInquiryService<DATA, ID> {

    List<DATA> findAll() throws ServiceException;

    Page<DATA> findAll(Pageable p_Pageable);

    DATA findById(ID p_ID) throws ServiceException;
}
