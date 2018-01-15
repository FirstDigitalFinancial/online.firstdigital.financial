package financial.firstdigital.online.security;

import java.util.Date;

/**
 * Created by Andrew on 15/01/2018.
 */
public class JwtToken {
    private Object userFingerPrint;
    private String userName;
    private Date expirationDate;
    private Date issuedAtDate;
    private Date withNotBeforeDate;

    public Object getUserFingerPrint() {
        return userFingerPrint;
    }

    public String getUserName() {
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
}
