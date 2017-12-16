package financial.firstdigital.online.service;

import financial.firstdigital.online.model.EmailDetail;
import financial.firstdigital.online.repository.EmailDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * The EmailDetailServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-23
 */

@Service("emailDetailService")
@Transactional
public class EmailDetailService {

    @Autowired
    EmailDetailRepository emailDetailRepository;

    public void saveEmailDetail(EmailDetail emailDetail) {
        emailDetailRepository.save(emailDetail);
    }

    public boolean exists(EmailDetail emailDetail) {
        if (emailDetail.getEmailId() != null && emailDetail.getEmailId() > 0 &&
                emailDetailRepository.exists(emailDetail.getEmailId())) {
            return true;
        }

        if (emailDetail.getEmailAddress() != null &&
                emailDetailRepository.findDistinctByEmailAddressEquals(emailDetail.getEmailAddress()) != null) {
            return true;
        }

        return false;
    }

    public EmailDetail findDistinctByEmailIdEquals(Long emailId) {
        return emailDetailRepository.findDistinctByEmailIdEquals(emailId);
    }
    public EmailDetail findDistinctByEmailAddressEquals(String emailAddress) {
        return emailDetailRepository.findDistinctByEmailAddressEquals(emailAddress);
    }
}
