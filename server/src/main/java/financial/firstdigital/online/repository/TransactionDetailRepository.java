package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.TransactionDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * The TransactionDetailRepository class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-17
 */

public interface TransactionDetailRepository extends CrudRepository<TransactionDetail,Long> {
    public TransactionDetail findDistinctByTransactionIdEquals(Long transactionId);
}
