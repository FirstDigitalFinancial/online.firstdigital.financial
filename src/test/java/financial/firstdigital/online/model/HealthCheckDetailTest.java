package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HealthCheckDetailTest {

    HealthCheckDetail healthCheckDetail;

    @Before
    public void setUp() throws Exception {
        healthCheckDetail = new HealthCheckDetail();
        healthCheckDetail.setHealthCheckId(1);
        healthCheckDetail.setHealthCheck(true);
    }

    @Test
    public void getHealthcheckId_HealthcheckIdIsGot_Passes() throws Exception {
        Assert.assertEquals(1, healthCheckDetail.getHealthCheckId());
    }

    @Test
    public void setHealthcheckId_HealthCheckIdIsSet_Passes() throws Exception {
        healthCheckDetail.setHealthCheckId(2);
        Assert.assertEquals(2, healthCheckDetail.getHealthCheckId());
    }

    @Test
    public void getHealthcheck_HealthCheckIsGot_Passes() {
        Assert.assertTrue(healthCheckDetail.getHealthCheck());
    }

    @Test
    public void setHealthcheck_HealthCheckIsSet_Passes() {
        healthCheckDetail.setHealthCheck(false);
        Assert.assertFalse(healthCheckDetail.getHealthCheck());
    }
}