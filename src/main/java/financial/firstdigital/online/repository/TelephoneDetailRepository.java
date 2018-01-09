package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.TelephoneDetail;
import org.springframework.data.repository.CrudRepository;

public interface TelephoneDetailRepository extends CrudRepository<TelephoneDetail, Long> {
    public TelephoneDetail findDistinctByTelephoneIdEquals(Long telephoneId);
    public TelephoneDetail findDistinctByTelephoneNumberEquals(Long teleponeNubmer);
    public TelephoneDetail findDistinctByVerificationCodeEquals(int verificationCode);
}
