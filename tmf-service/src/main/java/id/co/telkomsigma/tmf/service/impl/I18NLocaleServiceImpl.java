package id.co.telkomsigma.tmf.service.impl;

import id.co.telkomsigma.tmf.dao.II18NLocaleDao;
import id.co.telkomsigma.tmf.data.model.security.I18NLocale;
import id.co.telkomsigma.tmf.service.II18NLocaleService;
import id.co.telkomsigma.tmf.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
@Service
public class I18NLocaleServiceImpl extends AScaffoldingService<I18NLocale> implements II18NLocaleService {

	@Autowired
	private II18NLocaleDao i18NLocaleDao;
	
	@PostConstruct
	@Override
	public void init() {
		scaffoldingDAO = i18NLocaleDao;
	}
	
	@Override
	public List<I18NLocale> getAll() {
		return i18NLocaleDao.findAllByOrderByNameAsc();
	}

	@Override
	public List<I18NLocale> getAllListByStatus() {
		return i18NLocaleDao.findByStatusOrderByNameAsc(1);
	}

	@Override
	public Map<String, I18NLocale> getAllMapByStatus() {
		Map<String, I18NLocale> mapI18NLocale = new HashMap<String, I18NLocale>();
		for(I18NLocale i18nLocale : i18NLocaleDao.findByStatusOrderByNameAsc(1))
			mapI18NLocale.put(i18nLocale.getCode(), i18nLocale);
		return mapI18NLocale;
	}

	@Override
	public I18NLocale getLocaleCode(String code) {
		return i18NLocaleDao.findByCodeAndStatus(code, 1);
	}

	@Override
	public I18NLocale findById(Long p_ID) {
		return i18NLocaleDao.findOne(p_ID);
	}

	

}