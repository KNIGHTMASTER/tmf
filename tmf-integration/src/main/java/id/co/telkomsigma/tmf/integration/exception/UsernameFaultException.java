package id.co.telkomsigma.tmf.integration.exception;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public class UsernameFaultException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8233348693701011893L;
	
	public UsernameFaultException(String message) {
		super(message);
	}
	
	public UsernameFaultException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
