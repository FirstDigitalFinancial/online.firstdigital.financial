package financial.firstdigital.online.service.database;

import financial.firstdigital.online.model.AddressDetail;

import financial.firstdigital.online.repository.AddressDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

/**
 * The AddressDetailServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-17
 */

@Service("addressDetailService")
@Transactional
public class AddressDetailServiceImpl implements AddressDetailService {

    @Autowired
    AddressDetailRepository addressDetailRepository;

    public AddressDetail findDistinctByAddressIdEquals(Long addressId) {
        return addressDetailRepository.findDistinctByAddressIdEquals(addressId);
    }

    public void saveAddressDetailSet(Set<AddressDetail> addressDetailSet) {
        addressDetailRepository.save(addressDetailSet);
    }

    public AddressDetail findDistinctByHouseNumberEqualsAndPostCodeEquals(int houseNumber, String postCode) {
        return addressDetailRepository.findDistinctByHouseNumberEqualsAndPostCodeEquals(houseNumber, postCode);
    }


}
