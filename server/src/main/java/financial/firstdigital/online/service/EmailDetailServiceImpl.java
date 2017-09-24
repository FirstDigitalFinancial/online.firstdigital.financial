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
public class EmailDetailServiceImpl implements EmailDetailService {

    @Autowired
    EmailDetailRepository emailDetailRepository;

    public void saveEmailDetail(EmailDetail emailDetail) {
        emailDetailRepository.save(emailDetail);
    }

    public EmailDetail findDistinctByEmailIdEquals(Long emailId) {
        return emailDetailRepository.findDistinctByEmailIdEquals(emailId);
    }
    public EmailDetail findDistinctByEmailAddressEquals(String emailAddress) {
        return emailDetailRepository.findDistinctByEmailAddressEquals(emailAddress);
    }
}
