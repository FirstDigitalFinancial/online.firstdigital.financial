package financial.firstdigital.online.service;

import financial.firstdigital.online.repository.AccountDetailRepository;
import financial.firstdigital.online.model.AccountDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * The AccountDetailServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-16
 */

@Service("accountDetailService")
@Transactional
public class AccountDetailServiceImpl implements AccountDetailService {

    @Autowired
    private AccountDetailRepository accountDetailRepository;

    public AccountDetail findDistinctByAccountIdEquals(Long accountId) {

        return accountDetailRepository.findDistinctByAccountIdEquals(accountId);
    }

    public void saveAccountDetail(AccountDetail accountDetail) {
        accountDetailRepository.save(accountDetail);
    }


}
