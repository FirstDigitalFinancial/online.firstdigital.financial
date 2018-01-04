package financial.firstdigital.online.service.database;

import financial.firstdigital.online.model.TransactionDetail;

/**
 * The TransactionDetailService class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-17
 */

public interface TransactionDetailService {

    public void saveTransactionDetail(TransactionDetail transactionDetail);
    public TransactionDetail findDistinctByTransactionIdEquals(Long transactionId);

}
