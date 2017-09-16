package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.AccountDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * The AccountDetailDAO class
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-16
 */
public interface AccountDetailRepository extends CrudRepository<AccountDetail,Long> {

    public AccountDetail findDistinctByAccountIdEquals(Long accountId);

}