package id.co.telkomsigma.tmf.service.util;

/**
 * created on 1/20/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IEmailValidation {

    /**
     * Validate email if true or not
     * @return 1 : Valid, 0 : Invalid
     * @param p_Email Stirng email that will be validated
     */
    boolean validateByString(String p_Email);

    /**
     *
     * @param p_Email to Validate through Database
     * @return true if data is found
     */
    boolean validateByData(String p_Email);

    /**
     * Validate from String , Internet and Database
     * @param p_Email to validate
     * @return true if data is valid
     */
    boolean validateAll(String p_Email);


    /**
     * Validate email if exist in internet
     * @param p_Email to validate
     * @return true if email is valid
     */
    boolean validateByInternet(String p_Email);
    /**
     *
     * @param p_Email to validate
     * @return true if email is ready to register
     */
    boolean isReadyToRegister(String p_Email);
}
