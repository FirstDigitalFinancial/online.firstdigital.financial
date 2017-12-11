package financial.firstdigital.online.model;

import javax.persistence.*;

@Entity
@Table(name = "fdf_healthcheck_detail")
public class HealthCheckDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "healthCheckId", columnDefinition = "serial")
    private int healthCheckId;

    @Column(name = "healthcheck")
    private Boolean healthcheck;

    public int getHealthCheckId() {
        return healthCheckId;
    }

    public void setHealthCheckId(int healthCheckId) {
        this.healthCheckId = healthCheckId;
    }

    public boolean getHealthCheck() {
        return healthcheck;
    }

    public void setHealthCheck(Boolean healthcheck) {
        this.healthcheck = healthcheck;
    }
}
