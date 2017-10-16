package id.co.telkomsigma.tmf.service.scaffolding;

import id.co.telkomsigma.tmf.service.crud.ICrudInquiryService;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
public interface IInquiryService<DATA, ID> extends ICrudInquiryService<DATA, ID> {
	
	/*Property Code*/
	List<DATA> findByCode(String p_Code) throws ServiceException;
	
	List<DATA> findByCodeOrderByIdAsc(String p_Code) throws ServiceException;
	
	List<DATA> findByCodeOrderByCodeAsc(String p_Code) throws ServiceException;

	List<DATA> findByCodeOrderByCodeDesc(String p_Code) throws ServiceException;
	
	Page<DATA> findByCodeOrderByCodeAsc(String p_Code, Pageable p_Pageable) throws ServiceException;
	
	/*Property Name*/
	List<DATA> findByName(String p_Name);
	
	List<DATA> findByNameOrderByIdAsc(String p_Name) throws ServiceException;
	
	List<DATA> findByNameOrderByNameAsc(String p_Name) throws ServiceException;

	List<DATA> findByNameOrderByNameDesc(String p_Name) throws ServiceException;
	
	Page<DATA> findByNameOrderByNameAsc(String p_Name, Pageable p_Pageable) throws ServiceException;
	
	List<DATA> selectLOV();
	
	List<String> getPhysicalColumnNames();

	/*Page<DATA> advancedPagination(String p_FilterKey, String p_FilterValue, Pageable p_Pageable) throws ServiceException;*/
}