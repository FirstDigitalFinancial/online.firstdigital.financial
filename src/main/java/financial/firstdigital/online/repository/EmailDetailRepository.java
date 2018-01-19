package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.EmailDetail;
import org.springframework.data.repository.CrudRepository;

public interface EmailDetailRepository extends CrudRepository<EmailDetail, Long> {
    public EmailDetail findDistinctByEmailIdEquals(Long emailId);
    public EmailDetail findDistinctByEmailAddressEquals(String emailAddress);
    public EmailDetail findDistinctByVerificationKeyEquals(String verificationKey);
}
