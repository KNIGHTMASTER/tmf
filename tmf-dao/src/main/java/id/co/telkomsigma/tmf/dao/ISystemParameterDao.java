package id.co.telkomsigma.tmf.dao;

import id.co.telkomsigma.tmf.dao.scaffolding.IScaffoldingDAO;
import id.co.telkomsigma.tmf.data.model.system.SystemParameter;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface ISystemParameterDao extends IScaffoldingDAO<SystemParameter> {

	@Query("SELECT a FROM SystemParameter a WHERE a.code = ?1")
	public SystemParameter loadValue(String code) throws Exception;
	
	@Query("SELECT a FROM SystemParameter a WHERE a.code = ?1 OR a.code = ?2")
	public List<SystemParameter> listValue(String code1, String code2) throws Exception;
	
}
