package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.CustomerDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * The AccountDetailDAO class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-16
 */

public interface CustomerDetailRepository extends CrudRepository<CustomerDetail,Long> {
    public CustomerDetail findDistinctByCustomerIdEquals(Long customerId);
}
