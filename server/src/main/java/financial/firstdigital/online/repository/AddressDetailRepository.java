package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.AddressDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * The AddressDetailRepository class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-17
 */

public interface AddressDetailRepository extends CrudRepository<AddressDetail,Long> {
    public AddressDetail findDistinctByAddressIdEquals(Long addressId);
}
