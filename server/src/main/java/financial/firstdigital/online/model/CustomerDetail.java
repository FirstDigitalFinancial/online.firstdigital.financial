package financial.firstdigital.online.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * The CustomerDetail class contains information
 * about the customer
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-16
 */

@Entity
@Table(name = "fdf_customerdetail")
public class CustomerDetail {

    @Id
    @GeneratedValue
    @Column(name = "customerId", columnDefinition = "serial")
    private Long customerId;

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

    @ManyToOne
    @JoinColumn(name="addressId")
    private AddressDetail addressDetail;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public AddressDetail getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(AddressDetail addressDetail) {
        this.addressDetail = addressDetail;
    }

    @Override
    public String toString() {
        return "CustomerDetail{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", otherNames='" + otherNames + '\'' +
                ", gender=" + gender +
                ", addressDetail=" + addressDetail +
                '}';
    }
}
