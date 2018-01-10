package financial.firstdigital.online.service.database;

import financial.firstdigital.online.model.TelephoneDetail;

public interface TelephoneDetailService {

    public void saveTelephoneDetail(TelephoneDetail telephoneDetail);
    public boolean exists(TelephoneDetail telephoneDetail);
    public TelephoneDetail findDistinctByTelephoneIdEquals(Long emailId);
    public TelephoneDetail findDistinctByTelephoneNumberEquals(String telephoneNumber);
    public TelephoneDetail findDistinctByVerificationCodeIs(int verificationCode);

}
