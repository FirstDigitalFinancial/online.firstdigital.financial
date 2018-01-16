package financial.firstdigital.online.model.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "fdf_jwtToken")
public class JwtToken {

    @Column(name = "userFingerPrint", nullable = false)
    private String userFingerPrint;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "expirationDate", nullable = false)
    private Date expirationDate;

    @Column(name = "issuedAtDate", nullable = false)
    private Date issuedAtDate;

    @Column(name = "withNotBeforeDate", nullable = false)
    private Date withNotBeforeDate;

    @Id
    @Column(name = "tokenHash", unique = true, nullable = false)
    private String tokenHash;

    public JwtToken() {
    }

    public JwtToken(String userFingerPrint, String username, Date issuedAtDate, Date withNotBeforeDate, Date expirationDate) {
        this.userFingerPrint = userFingerPrint;
        this.userName = username;
        this.issuedAtDate = issuedAtDate;
        this.withNotBeforeDate = withNotBeforeDate;
        this.expirationDate = expirationDate;
    }

    public String getUserFingerPrint() {
        return userFingerPrint;
    }

    public String getUsername() {
        return userName;
    }

    public String getType() {
        return "JWT";
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Date getIssuedAtDate() {
        return issuedAtDate;
    }

    public Date getWithNotBeforeDate() {
        return withNotBeforeDate;
    }

    public void setUserFingerPrint(String userFingerPrint) {
        this.userFingerPrint = userFingerPrint;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setIssuedAtDate(Date issuedAtDate) {
        this.issuedAtDate = issuedAtDate;
    }

    public void setWithNotBeforeDate(Date withNotBeforeDate) {
        this.withNotBeforeDate = withNotBeforeDate;
    }

    public String getTokenHash() {
        return tokenHash;
    }

    public void setTokenHash(String tokenHash) {
        this.tokenHash = tokenHash;
    }
}
