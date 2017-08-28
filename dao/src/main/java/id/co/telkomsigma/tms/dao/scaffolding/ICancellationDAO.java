package id.co.telkomsigma.tms.dao.scaffolding;

import id.co.telkomsigma.tms.dao.exception.DAOException;
import id.co.telkomsigma.tms.data.constant.TmsConstant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * created on 10/17/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <ID>
 */
@Transactional
public interface ICancellationDAO<ID extends Serializable> {
	
	@Modifying
    @Query("UPDATE #{#entityName} a set a.status = "+ TmsConstant.Query.STATUS_CANCELLED)
    void cancelAll() throws DAOException;
	
	@Modifying
    @Query("UPDATE #{#entityName} a set a.status = "+TmsConstant.Query.STATUS_CANCELLED+" where a.id = ?1")
	void cancelSingleData(ID p_Id) throws DAOException;

}
