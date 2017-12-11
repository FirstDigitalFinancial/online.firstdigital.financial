package financial.firstdigital.online.service;

import financial.firstdigital.online.model.HealthCheckDetail;
import financial.firstdigital.online.repository.HealthCheckDetailRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class HealthCheckDetailServiceImplTest {

    @Mock
    HealthCheckDetailRepository mockHealthCheckDetailRepository;

    @InjectMocks
    HealthCheckDetailService healthCheckDetailServiceUnderTest = new HealthCheckDetailServiceImpl();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        HealthCheckDetail healthCheckDetail = new HealthCheckDetail();
        healthCheckDetail.setHealthCheckId(1);
        healthCheckDetail.setHealthCheck(true);

        when(mockHealthCheckDetailRepository.findDistinctByHealthCheckId(1)).thenReturn(healthCheckDetail);

    }

    @Test
    public void isHealthy_HealthCheckDetailIsGot_Passes() {
        Assert.assertTrue(healthCheckDetailServiceUnderTest.isHealthy());
    }
}