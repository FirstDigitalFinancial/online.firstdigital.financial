package financial.firstdigital.online.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * The Town class contains information
 * about Towns in the UK
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-17
 */

@Entity
@Table(name = "fdf_town")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "townId", columnDefinition = "serial")
    private int townId;

    @Column(name = "townName")
    private String townName;

    public Town() {}

    public Town(int townId, String townName) {
        this.townId = townId;
        this.townName = townName;
    }

    public int getTownId() {
        return townId;
    }

    public void setTownId(int townId) { this.townId = townId; }

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