package id.co.telkomsigma.tms.data.exception;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * 
 */
public abstract class ASigmaException extends Exception{

	/**
     *
	 * 
	 */
	private static final long serialVersionUID = -3006085274327484535L;

	protected static final Logger LOGGER = LoggerFactory.getLogger(ASigmaException.class);

    public ASigmaException(String p_Message) {
        this(p_Message, null);
    }

    public ASigmaException(String p_Message, Throwable p_Throwable) {
        super(p_Message, p_Throwable);
        if (p_Message != null && p_Throwable != null) {
            LOGGER.info(p_Message);
            p_Throwable.printStackTrace();

        } else {
            if (p_Message != null) {
                LOGGER.info(p_Message);
            }
            if (p_Throwable != null) {
                LOGGER.error(p_Throwable.getMessage());
                p_Throwable.printStackTrace();
            }
        }
    }
}
