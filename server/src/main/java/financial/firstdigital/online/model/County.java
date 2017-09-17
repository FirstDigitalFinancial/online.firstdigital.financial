package financial.firstdigital.online.model;

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
    @GeneratedValue
    @Column(name = "countyId", columnDefinition = "serial")
    private int countyId;

    @Column(name = "countyName")
    private String countyName;

    public int getCountyId() {
        return countyId;
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
