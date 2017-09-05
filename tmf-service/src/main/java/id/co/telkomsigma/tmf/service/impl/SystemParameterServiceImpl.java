package id.co.telkomsigma.tmf.service.impl;

import id.co.telkomsigma.tmf.dao.ISystemParameterDao;
import id.co.telkomsigma.tmf.data.model.system.SystemParameter;
import id.co.telkomsigma.tmf.service.ISystemParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class SystemParameterServiceImpl implements ISystemParameterService {
	
	@Autowired
	private ISystemParameterDao systemParameterDao;

	@Override
	public SystemParameter loadValue(String code) throws Exception {
		return systemParameterDao.loadValue(code);
	}

	@Override
	public List<SystemParameter> listValue(String code1, String code2) throws Exception {
		return systemParameterDao.listValue(code1, code2);
	}

	@Override
	public List<SystemParameter> getListSystemParameter() throws Exception {
		return systemParameterDao.findAll();
	}

	@Override
	public Map<String, String> getMapSystemParameter() throws Exception {
		Map<String, String> mapSystemParameter = new HashMap<String, String>();
		for(SystemParameter systemParameter : systemParameterDao.findAll()){
			mapSystemParameter.put(systemParameter.getCode(), systemParameter.getCode());
		}
		return mapSystemParameter;
	}

}