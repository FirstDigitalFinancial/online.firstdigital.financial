package financial.firstdigital.online.model;

import javax.persistence.*;

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

    @Column(name = "isVerified")
    private Boolean isVerified;

    @Column(name = "verificationKey")
    private String verificationKey;

    public TelephoneDetail() {
    }

    public TelephoneDetail(String telephoneNumber, ContactType contactType, Boolean isVerified, String verificationKey) {
        this.telephoneNumber = telephoneNumber;
        this.contactType = contactType;
        this.isVerified = isVerified;
        this.verificationKey = verificationKey;
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
        this.telephoneNumber = telephoneNumber;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public String getVerificationKey() {
        return verificationKey;
    }

    public void setVerificationKey(String verificationKey) {
        this.verificationKey = verificationKey;
    }

    @Override
    public String toString() {
        return "TelephoneDetail{" +
                "telephoneId=" + telephoneId +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", contactType=" + contactType +
                ", isVerified=" + isVerified +
                ", verificationKey='" + verificationKey + '\'' +
                '}';
    }
}
