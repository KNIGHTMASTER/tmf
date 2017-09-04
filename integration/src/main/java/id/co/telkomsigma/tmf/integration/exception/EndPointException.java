package id.co.telkomsigma.tmf.integration.exception;

import id.co.telkomsigma.tmf.data.exception.ASigmaException;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class EndPointException extends ASigmaException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3121502315924173984L;

	public EndPointException(String p_Message, Throwable p_Throwable) {
		super(p_Message, p_Throwable);
	}

	public EndPointException(String p_Message) {
		super(p_Message);
	}

	
}
