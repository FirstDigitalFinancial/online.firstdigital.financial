package financial.firstdigital.online.dao;

import financial.firstdigital.online.model.AccountDetail;

/**
 * The AccountDetailDAO class
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-16
 */
public interface AccountDetailDAO {
    public AccountDetail getAccountDetailByAccountNumber(Long accountNumber);
}