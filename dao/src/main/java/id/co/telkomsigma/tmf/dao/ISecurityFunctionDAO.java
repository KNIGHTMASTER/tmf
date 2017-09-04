package id.co.telkomsigma.tmf.dao;

import id.co.telkomsigma.tmf.dao.exception.DAOException;
import id.co.telkomsigma.tmf.dao.scaffolding.IScaffoldingDAO;
import id.co.telkomsigma.tmf.data.model.security.SecurityFunction;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISecurityFunctionDAO extends IScaffoldingDAO<SecurityFunction> {
	
	@Query("select a from SecurityFunction a where a.parentFunction = ?1")
    List<SecurityFunction> findByParentFunction(SecurityFunction p_Function) throws DAOException;
}
