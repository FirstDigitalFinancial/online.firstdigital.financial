package financial.firstdigital.online.service.database;

import financial.firstdigital.online.model.TelephoneDetail;
import financial.firstdigital.online.repository.TelephoneDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("telephoneDetailService")
@Transactional
public class TelephoneDetailServiceImpl implements TelephoneDetailService {

    @Autowired
    private TelephoneDetailRepository telephoneDetailRepository;

    public void saveTelephoneDetail(TelephoneDetail telephoneDetail) {
        telephoneDetailRepository.save(telephoneDetail);
    }

    public boolean exists(TelephoneDetail telephoneDetail) {
        if (telephoneDetail.getTelephoneId() != null && telephoneDetail.getTelephoneId() > 0 &&
                telephoneDetailRepository.exists(telephoneDetail.getTelephoneId())) {
            return true;
        }

        if (telephoneDetail.getTelephoneNumber() != null &&
                telephoneDetailRepository.findDistinctByTelephoneNumberEquals(telephoneDetail.getTelephoneNumber()) != null) {
            return true;
        }

        return false;
    }

    public TelephoneDetail findDistinctByTelephoneIdEquals(Long emailId) {
        return telephoneDetailRepository.findDistinctByTelephoneIdEquals(emailId);
    }
    public TelephoneDetail findDistinctByTelephoneNumberEquals(String telephoneNumber) {
        return telephoneDetailRepository.findDistinctByTelephoneNumberEquals(telephoneNumber);
    }
    public TelephoneDetail findDistinctByVerificationCodeIs(int verificationCode) {
        System.out.println("Searching for " + verificationCode);
        return telephoneDetailRepository.findDistinctByVerificationCodeIs(verificationCode);
    }
}
