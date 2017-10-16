package id.co.telkomsigma.tmf.service.crud;

/**
 * Created on 10/16/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <KEY>
 */
public interface ICrudService<DATA, KEY> extends ICrudInquiryService<DATA, KEY>, ICrudTransactionService<DATA, KEY> {
}
