package financial.firstdigital.online.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * The CustomerDetail class contains information
 * about the customer
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-16
 */

@Entity
@Table(name = "fdf_customer_detail")
public class CustomerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId", columnDefinition = "serial")
    private Long customerId;

    @ManyToOne
    @JoinColumn(name = "titleId")
    private Title title;

    @Column(name = "firstName", length = 50)
    @Size(max = 50)
    private String firstName;

    @Column(name = "lastName", length = 50)
    @Size(max = 50)
    private String lastName;

    @Column(name = "otherNames", length = 250)
    @Size(max = 250)
    private String otherNames;

    @Column(name = "gender")
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="fdf_customer_address_detail", joinColumns={@JoinColumn(name="customerId", referencedColumnName="customerId")}
            , inverseJoinColumns={@JoinColumn(name="addressId", referencedColumnName="addressId")})
    private Set<AddressDetail> addressDetailSet;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="fdf_customer_email_detail", joinColumns={@JoinColumn(name="customerId", referencedColumnName="customerId")}
            , inverseJoinColumns={@JoinColumn(name="emailId", referencedColumnName="emailId")})
    private Set<EmailDetail> emailDetailSet;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="fdf_customer_account_detail", joinColumns={@JoinColumn(name="customerId", referencedColumnName="customerId")}
            , inverseJoinColumns={@JoinColumn(name="accountId", referencedColumnName="accountId")})
    private Set<AccountDetail> accountDetailSet;

    @OneToOne
    @JoinColumn(name="customerId", referencedColumnName = "marketingPreferenceId", nullable = true)
    private MarketingPreferenceDetail marketingPreferenceDetail;

//    @OneToOne
//    @JoinColumn(name = "loginId")
//    private LoginDetail loginDetail;

    public Long getCustomerId() {
        return customerId;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<AddressDetail> getAddressDetailSet() {
        return addressDetailSet;
    }

    public void setAddressDetailSet(Set<AddressDetail> addressDetailSet) {
        this.addressDetailSet = addressDetailSet;
    }

    public Set<EmailDetail> getEmailDetailSet() {
        return emailDetailSet;
    }

    public void setEmailDetail(Set<EmailDetail> emailDetailSet) {
        this.emailDetailSet = emailDetailSet;
    }

    public Set<AccountDetail> getAccountDetailSet() { return accountDetailSet; }

    public void setAccountDetailSet(Set<AccountDetail> accountDetailSet) {
        this.accountDetailSet = accountDetailSet;
    }

    public MarketingPreferenceDetail getMarketingPreferenceDetail() {
        return marketingPreferenceDetail;
    }

    public void setMarketingPreferenceDetail(MarketingPreferenceDetail marketingPreferenceDetail) {
        this.marketingPreferenceDetail = marketingPreferenceDetail;
    }

//    public LoginDetail getLoginDetail() {
//        return loginDetail;
//    }
//
//    public void setLoginDetail(LoginDetail loginDetail) {
//        this.loginDetail = loginDetail;
//    }

    @Override
    public String toString() {
        return "CustomerDetail{" +
                "customerId=" + customerId +
                ", title=" + title +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", otherNames='" + otherNames + '\'' +
                ", gender=" + gender +
                ", addressDetailSet=" + addressDetailSet +
                ", emailDetailSet='" + emailDetailSet + '\'' +
                ", accountDetailSet=" + accountDetailSet +
                ", marketingPreferenceDetail=" + marketingPreferenceDetail +
//                ", loginDetail=" + loginDetail +
                '}';
    }
}
