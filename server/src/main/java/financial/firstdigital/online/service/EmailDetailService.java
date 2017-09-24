package financial.firstdigital.online.service;

import financial.firstdigital.online.model.EmailDetail;

/**
 * The CustomerDetailService interface
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-16
 */

public interface EmailDetailService {
    public void saveEmailDetail(EmailDetail emailDetail);
    public EmailDetail findDistinctByEmailIdEquals(Long emailId);
    public EmailDetail findDistinctByEmailAddressEquals(String emailAddress);
}
