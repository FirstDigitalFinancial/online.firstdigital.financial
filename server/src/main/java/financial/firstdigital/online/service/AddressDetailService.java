package financial.firstdigital.online.service;

import financial.firstdigital.online.model.AddressDetail;

/**
 * The AddressDetailService interface
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-17
 */

public interface AddressDetailService {

    public void saveAddressDetail(AddressDetail addressDetail);
    public AddressDetail findDistinctByAddressIdEquals(Long addressId);

}
