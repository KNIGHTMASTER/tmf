package id.co.telkomsigma.tmf.service.scaffolding;

import id.co.telkomsigma.tmf.service.crud.ICrudTransactionService;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
public interface ITransactionService<DATA, ID> extends ICrudTransactionService<DATA, ID>, ICancellationService<ID>, IApprovalService<ID> {
}
