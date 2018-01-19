package financial.firstdigital.online.model;

import javax.persistence.*;

@Entity
@Table(name = "fdf_email_detail")
public class EmailDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emailId", columnDefinition = "serial")
    private Long emailId;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "contactType")
    private ContactType contactType = ContactType.PRIMARY;

    @Column(name = "isVerified")
    private Boolean isVerified;

    @Column(name = "verificationKey")
    private String verificationKey;

    public Long getEmailId() {
        return emailId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ContactType getEmailType() {
        return contactType;
    }

    public void setEmailType(ContactType contactType) {
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

    public EmailDetail() {

    }

    public EmailDetail(Long emailId, String emailAddress, ContactType contactType, Boolean isVerified, String verificationKey) {
        this.emailId = emailId;
        this.emailAddress = emailAddress;
        this.contactType = contactType;
        this.isVerified = isVerified;
        this.verificationKey = verificationKey;
    }

    @Override
    public String toString() {
        return "EmailDetail{" +
                "emailId=" + emailId +
                ", emailAddress='" + emailAddress + '\'' +
                ", contactType=" + contactType +
                ", isVerified=" + isVerified +
                ", verificationKey='" + verificationKey + '\'' +
                '}';
    }
}
