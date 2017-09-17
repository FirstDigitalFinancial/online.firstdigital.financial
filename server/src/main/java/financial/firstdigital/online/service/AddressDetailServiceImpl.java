package financial.firstdigital.online.service;

import financial.firstdigital.online.model.AddressDetail;

import financial.firstdigital.online.repository.AddressDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * The AddressDetailServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
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

    public void saveAddressDetail(AddressDetail addressDetail) {
        addressDetailRepository.save(addressDetail);
    }

}
