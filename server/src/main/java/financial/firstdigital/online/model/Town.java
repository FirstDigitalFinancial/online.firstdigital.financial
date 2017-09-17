package financial.firstdigital.online.model;

import javax.persistence.*;

/**
 * The Town class contains information
 * about Towns in the UK
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-17
 */

@Entity
@Table(name = "fdf_town")
public class Town {

    @Id
    @GeneratedValue
    @Column(name = "townId", columnDefinition = "serial")
    private int townId;

    @Column(name = "townName")
    private String townName;

    public int getTownId() {
        return townId;
    }

    public String getTownName() {
        return townName;
    }

    @Override
    public String toString() {
        return "town{" +
                "townId=" + townId +
                ", townName='" + townName + '\'' +
                '}';
    }
    
}