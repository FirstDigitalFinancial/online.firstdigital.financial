package financial.firstdigital.online.service;

import financial.firstdigital.online.model.TransactionDetail;
import financial.firstdigital.online.repository.TransactionDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * The TransactionDetailServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-17
 */

@Service("transactionDetailService")
@Transactional

public class TransactionDetailServiceImpl implements TransactionDetailService {

    @Autowired
    private TransactionDetailRepository transactionDetailRepository;

    @Override
    public void saveTransactionDetail(TransactionDetail transactionDetail) {
        transactionDetailRepository.save(transactionDetail);
    }

    @Override
    public TransactionDetail findDistinctByTransactionIdEquals(Long transactionId) {
        return transactionDetailRepository.findDistinctByTransactionIdEquals(transactionId);
    }
}
