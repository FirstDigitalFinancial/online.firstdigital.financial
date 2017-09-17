package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.AddressDetail;
import org.springframework.data.repository.CrudRepository;

public interface AddressDetailRepository extends CrudRepository<AddressDetail,Long> {
    public AddressDetail findDistinctByAddressIdEquals(Long addressId);
}
