package financial.firstdigital.online.service;

import financial.firstdigital.online.dao.AccountDetailDAO;
import financial.firstdigital.online.model.AccountDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * The PostServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-16
 */

@Service("accountDetailService")
@Transactional
public class AccountDetailsServiceImpl implements AccountDetailService {

    @Autowired
    private AccountDetailDAO accountDetailDAO;

    public AccountDetail getAccountByAccountNumber(Long accountNumber) {

        return accountDetailDAO.getAccountDetailByAccountNumber(accountNumber);
    }


}
