package id.co.telkomsigma.tmf.service.scaffolding;

import id.co.telkomsigma.tmf.service.exception.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <ID>
 */
public interface IApprovalService<ID> {

	@Transactional
	void approveAll() throws ServiceException;

	@Transactional
	void approveSingleData(ID p_ID) throws ServiceException;

}
