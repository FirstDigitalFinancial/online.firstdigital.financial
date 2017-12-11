package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HealthcheckDetailTest {

    HealthcheckDetail healthcheckDetail;

    @Before
    public void setUp() throws Exception {
        healthcheckDetail = new HealthcheckDetail();
        healthcheckDetail.setHealthcheckId(1);
        healthcheckDetail.setHealthcheck(true);
    }

    @Test
    public void getHealthcheckId_HealthcheckIdIsGot_Passes() throws Exception {
        Assert.assertEquals(1, healthcheckDetail.getHealthcheckId());
    }

    @Test
    public void setHealthcheckId_HealthCheckIdIsSet_Passes() throws Exception {
        healthcheckDetail.setHealthcheckId(2);
        Assert.assertEquals(2, healthcheckDetail.getHealthcheckId());
    }

    @Test
    public void getHealthcheck_HealthCheckIsGot_Passes() {
        Assert.assertTrue(healthcheckDetail.getHealthcheck());
    }

    @Test
    public void setHealthcheck_HealthCheckIsSet_Passes() {
        healthcheckDetail.setHealthcheck(false);
        Assert.assertFalse(healthcheckDetail.getHealthcheck());
    }
}