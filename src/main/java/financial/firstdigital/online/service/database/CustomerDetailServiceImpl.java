package financial.firstdigital.online.service.database;

import financial.firstdigital.online.model.CustomerDetail;
import financial.firstdigital.online.repository.CustomerDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * The CustomerDetailServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-16
 */

@Service("customerDetailService")
@Transactional
public class CustomerDetailServiceImpl implements CustomerDetailService {

    @Autowired
    private CustomerDetailRepository customerDetailRepository;

    public void saveCustomerDetail(CustomerDetail customerDetail) {
        customerDetailRepository.save(customerDetail);
    }
    public CustomerDetail findDistinctByCustomerIdEquals(Long customerId) {
        return customerDetailRepository.findDistinctByCustomerIdEquals(customerId);
    }

}
