package id.co.telkomsigma.tms.service.scaffolding;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public interface IScaffoldingService<DATA> extends IInquiryService<DATA, Long>, ITransactionService<DATA, Long> {
	String generateRandomCode();
}