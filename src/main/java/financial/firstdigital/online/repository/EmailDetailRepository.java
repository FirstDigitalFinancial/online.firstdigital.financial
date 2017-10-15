package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.EmailDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * The EmailDetailRepository class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-23
 */

public interface EmailDetailRepository extends CrudRepository<EmailDetail, Long> {
    public EmailDetail findDistinctByEmailIdEquals(Long emailId);
    public EmailDetail findDistinctByEmailAddressEquals(String emailAddress);
}
