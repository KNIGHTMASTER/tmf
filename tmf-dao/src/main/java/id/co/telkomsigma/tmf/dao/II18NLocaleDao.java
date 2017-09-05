package id.co.telkomsigma.tmf.dao;

import id.co.telkomsigma.tmf.dao.scaffolding.IScaffoldingDAO;
import id.co.telkomsigma.tmf.data.model.security.I18NLocale;

import java.util.List;

/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface II18NLocaleDao extends IScaffoldingDAO<I18NLocale> {

	public List<I18NLocale> findAllByOrderByNameAsc();

	public List<I18NLocale> findByStatusOrderByNameAsc(Integer status);
	
	public I18NLocale findByCodeAndStatus(String code, Integer status);
	
}
