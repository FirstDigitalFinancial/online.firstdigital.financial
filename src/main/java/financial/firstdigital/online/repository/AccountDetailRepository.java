package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.AccountDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * The AccountDetailRepository class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-17
 */

public interface AccountDetailRepository extends CrudRepository<AccountDetail,Long> {

    public AccountDetail findDistinctByAccountIdEquals(Long accountId);

}