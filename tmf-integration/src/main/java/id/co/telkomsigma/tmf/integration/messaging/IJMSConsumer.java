package id.co.telkomsigma.tmf.integration.messaging;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <MESSAGE>
 */
public interface IJMSConsumer<MESSAGE> {

    void receive(MESSAGE p_Message);
}
