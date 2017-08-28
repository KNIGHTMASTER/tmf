package id.co.telkomsigma.tms.dao.exception;

import id.co.telkomsigma.tms.data.exception.ASigmaException;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * 
 */
public class DAOException extends ASigmaException {

	public DAOException(String p_Message) {
		super(p_Message);
	}

	public DAOException(String p_Message, Throwable p_Throwable) {
		super(p_Message, p_Throwable);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
