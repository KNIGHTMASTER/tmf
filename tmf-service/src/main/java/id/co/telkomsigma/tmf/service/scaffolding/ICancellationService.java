package id.co.telkomsigma.tmf.service.scaffolding;

import id.co.telkomsigma.tmf.service.exception.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <ID>
 */
public interface ICancellationService<ID> {

	@Transactional
	void cancelAll() throws ServiceException;

	@Transactional
	void cancelSingleData(ID p_ID) throws ServiceException;
}
