package financial.firstdigital.online.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * The County class contains information
 * about counties in the UK
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-17
 */

@Entity
@Table(name = "fdf_county")
public class County {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "countyId", columnDefinition = "serial")
    private int countyId;

    @Column(name = "countyName")
    private String countyName;

    public County() {
    }

    public County(int countyId, String countyName) {
        this.countyId = countyId;
        this.countyName = countyName;
    }

    public void setCountyId(int countyId) {
        this.countyId = countyId;
    }

    public int getCountyId() {
        return countyId;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountyName() {
        return countyName;
    }

    @Override
    public String toString() {
        return "County{" +
                "countyId=" + countyId +
                ", countyName='" + countyName + '\'' +
                '}';
    }
}
