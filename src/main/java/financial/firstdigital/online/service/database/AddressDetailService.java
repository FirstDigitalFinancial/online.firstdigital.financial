package financial.firstdigital.online.service.database;

import financial.firstdigital.online.model.AddressDetail;

import java.util.Set;

/**
 * The AddressDetailService interface
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-17
 */

public interface AddressDetailService {

    public void saveAddressDetailSet(Set<AddressDetail> addressDetailSet);
    public AddressDetail findDistinctByAddressIdEquals(Long addressId);
    public AddressDetail findDistinctByHouseNumberEqualsAndPostCodeEquals(int houseNumber, String postCode);

}
