package id.co.telkomsigma.tmf.security.handler.base;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.dto.ResponseData;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class ABaseResponseHandler implements IBaseResponseHandler {
	
	protected EResponseCode responseCode = EResponseCode.RC_FAILURE;

	@Override
	public ResponseData abort() {
		ResponseData responseData = new ResponseData();
		responseData.setResponseCode(getResponseCode().getResponseCode());
		responseData.setResponseMsg(getResponseCode().getResponseMsg());
		return responseData;
	}
	
}
