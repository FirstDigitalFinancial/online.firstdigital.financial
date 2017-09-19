package financial.firstdigital.online.model;

import javax.persistence.*;

/**
 * The AddressDetail class contains information
 * about the customer account
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-17
 */

@Entity
@Table(name = "fdf_address_detail")
public class AddressDetail {

    @Id
    @GeneratedValue
    @Column(name = "addressId", columnDefinition = "serial")
    private long addressId;

    @Column(name = "houseNumber")
    private int houseNumber;

    @Column(name = "houseName", length = 100)
    private String houseName;

    @Column(name = "streetName", length = 100)
    private String streetName;

    @ManyToOne
    @JoinColumn(name="townId")
    private Town town;

    @ManyToOne
    @JoinColumn(name="countyId")
    private County county;

    @Column(name = "postCode", length = 10)
    private String postCode;

    public long getAddressId() {
        return addressId;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
