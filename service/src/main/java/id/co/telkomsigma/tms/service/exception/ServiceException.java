package id.co.telkomsigma.tms.service.exception;

import id.co.telkomsigma.tms.data.exception.ASigmaException;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public class ServiceException extends ASigmaException {

	/**
	 *
	 *
	 */
	private static final long serialVersionUID = -946741192849089787L;
	
	public ServiceException(String p_Message, Throwable p_Throwable) {
		super(p_Message, p_Throwable);
	}

	public ServiceException(String p_Message) {
		super(p_Message);
	}


}
