package financial.firstdigital.online.model;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "fdf_telephone_detail")
public class TelephoneDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "telephoneId", columnDefinition = "serial")
    private Long telephoneId;

    @Column(name = "telephoneNumber")
    private String telephoneNumber;

    @Column(name = "contactType")
    private ContactType contactType = ContactType.PRIMARY;

    @Column(name = "telephoneType")
    private TelephoneType telephoneType;

    @Column(name = "isVerified")
    private Boolean isVerified;

    @Column(name = "verificationCode")
    private int verificationCode;

    public TelephoneDetail() {
        this.isVerified = false;
        this.generateVerificationCode();
    }

    public TelephoneDetail(String telephoneNumber, ContactType contactType, TelephoneType telephoneType, Boolean isVerified) {
        this.telephoneNumber = telephoneNumber;
        this.contactType = contactType;
        this.telephoneType = telephoneType;
        this.isVerified = false;
        this.generateVerificationCode();
    }

    public Long getTelephoneId() {
        return telephoneId;
    }

    public void setTelephoneId(Long telephoneId) {
        this.telephoneId = telephoneId;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.setVerified(false);
        this.generateVerificationCode();
        this.telephoneNumber = telephoneNumber;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public TelephoneType getTelephoneType() {
        return telephoneType;
    }

    public void setTelephoneType(TelephoneType telephoneType) {
        this.telephoneType = telephoneType;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public int getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(int verificationCode) {
        this.verificationCode = verificationCode;
    }

    public void generateVerificationCode() {
        setVerificationCode((int) Math.floor(Math.random() * 100000 + 1));
    }

    @Override
    public String toString() {
        return "TelephoneDetail{" +
                "telephoneId=" + telephoneId +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", contactType=" + contactType +
                ", telephoneType=" + telephoneType +
                ", isVerified=" + isVerified +
                ", verificationCode='" + verificationCode + '\'' +
                '}';
    }
}
