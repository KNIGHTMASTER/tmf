package id.co.telkomsigma.tmf.service;

import id.co.telkomsigma.tmf.data.model.security.I18NLocale;
import id.co.telkomsigma.tmf.service.scaffolding.IScaffoldingService;

import java.util.List;
import java.util.Map;

/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface II18NLocaleService extends IScaffoldingService<I18NLocale> {

	public List<I18NLocale> getAll();
	
	public List<I18NLocale> getAllListByStatus();
	
	public Map<String, I18NLocale> getAllMapByStatus();
	
	public I18NLocale getLocaleCode(String code);

	I18NLocale findById(Long p_ID);
}
