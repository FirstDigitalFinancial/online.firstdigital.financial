package financial.firstdigital.online.model;

import javax.persistence.*;

/**
 * The EmailDetail class contains information
 * about the customers login details
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-21
 */

@Entity
@Table(name = "fdf_email_detail")
public class EmailDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emailId", columnDefinition = "serial")
    private Long emailId;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "emailType")
    private EmailType emailType;

    @Column(name = "isVerified")
    private Boolean isVerified;

    public Long getEmailId() {
        return emailId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public EmailType getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailType emailType) {
        this.emailType = emailType;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public EmailDetail() {

    }

    public EmailDetail(Long emailId, String emailAddress, EmailType emailType, Boolean isVerified) {
        this.emailId = emailId;
        this.emailAddress = emailAddress;
        this.emailType = emailType;
        this.isVerified = isVerified;
    }

    @Override
    public String toString() {
        return "EmailDetail{" +
                "emailId=" + emailId +
                ", emailAddress='" + emailAddress + '\'' +
                ", emailType=" + emailType +
                ", isVerified=" + isVerified +
                '}';
    }
}
