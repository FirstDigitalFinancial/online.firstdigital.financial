package financial.firstdigital.online.model;

import javax.persistence.*;

@Entity
@Table(name = "fdf_healthcheck_detail")
public class HealthcheckDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "healthcheckId", columnDefinition = "serial")
    private int healthcheckId;

    @Column(name = "healthcheck")
    private Boolean healthcheck;

    public int getHealthcheckId() {
        return healthcheckId;
    }

    public void setHealthcheckId(int healthcheckId) {
        this.healthcheckId = healthcheckId;
    }

    public boolean getHealthcheck() {
        return healthcheck;
    }

    public void setHealthcheck(Boolean healthcheck) {
        this.healthcheck = healthcheck;
    }
}
