package id.co.telkomsigma.tmf.service;

import id.co.telkomsigma.tmf.data.model.system.SystemParameter;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public interface ISystemParameterService {

	public SystemParameter loadValue(String code) throws Exception;
	
	public List<SystemParameter> listValue(String code1, String code2) throws Exception;
	
	public List<SystemParameter> getListSystemParameter() throws Exception;
	
	public Map<String, String> getMapSystemParameter() throws Exception;
}