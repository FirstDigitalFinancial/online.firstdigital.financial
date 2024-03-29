package financial.firstdigital.online.service.database;

import financial.firstdigital.online.model.CustomerDetail;

/**
 * The CustomerDetailService interface
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-16
 */

public interface CustomerDetailService {

    public void saveCustomerDetail(CustomerDetail customerDetail);
    public CustomerDetail findDistinctByCustomerIdEquals(Long customerId);

}
