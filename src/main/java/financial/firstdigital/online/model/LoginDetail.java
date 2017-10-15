package financial.firstdigital.online.model;

import javax.persistence.*;

/**
 * The LoginDetail class contains information
 * about the customers login details
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-20
 */

@Entity
@Table(name = "fdf_login_detail")
public class LoginDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loginId", columnDefinition = "serial")
    private Long loginId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "masterPin")
    private int masterPin;

    @Column(name = "loginAttempt")
    private int loginAttempt;

    @Column(name = "accountStatus")
    private Boolean accountStatus;

    public Long getLoginId() {
        return loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMasterPin() {
        return masterPin;
    }

    public void setMasterPin(int masterPin) {
        this.masterPin = masterPin;
    }

    @Override
    public String toString() {
        return "LoginDetail{" +
                "loginId=" + loginId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", masterPin=" + masterPin +
                '}';
    }
}
