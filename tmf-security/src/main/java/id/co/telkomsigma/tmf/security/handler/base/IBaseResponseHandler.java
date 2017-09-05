package id.co.telkomsigma.tmf.security.handler.base;


import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.dto.ResponseData;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface IBaseResponseHandler {

	public ResponseData abort();
	
	public EResponseCode getResponseCode();
	
}
