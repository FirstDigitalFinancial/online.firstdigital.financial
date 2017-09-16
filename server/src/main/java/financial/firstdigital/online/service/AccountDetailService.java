package financial.firstdigital.online.service;

import financial.firstdigital.online.model.AccountDetail;

/**
 * The UserService interface
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-16
 */

public interface AccountDetailService {

    public void saveAccountDetail(AccountDetail accountDetail);
    public AccountDetail findDistinctByAccountNumberEquals(Long accountNumber);

}
