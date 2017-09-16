package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.TransactionDetail;
import org.springframework.data.repository.CrudRepository;

public interface TransactionDetailRepository extends CrudRepository<TransactionDetail,Long> {
    public TransactionDetail findDistinctByTransactionIdEquals(Long transactionId);
}
