package financial.firstdigital.online.controller;

import financial.firstdigital.online.Application;
import financial.firstdigital.online.service.database.HealthCheckDetailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@TestPropertySource(
        locations = "classpath:test.properties")
public class HealthCheckControllerTest {

    private MockMvc mockMvc;

    @Mock
    private HealthCheckDetailService mockHealthCheckDetailService;

    @InjectMocks
    private HealthCheckController healthCheckController;

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {
        // this must be called for the @Mock annotations above to be processed
        // and for the mock service to be injected into the controller under
        // test.
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(healthCheckController).build();

    }

    @Test
    public void getHealthCheck_HealthyHealthCheckIsGot_Passes() throws Exception {

        when(mockHealthCheckDetailService.isHealthy()).thenReturn(true);

        mockMvc.perform(get("/healthcheck"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("OK")));
    }

    @Test
    public void getHealthCheck_UnhealthyHealthCheckIsGot_Passes() throws Exception {

        when(mockHealthCheckDetailService.isHealthy()).thenReturn(false);

        mockMvc.perform(get("/healthcheck"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("DOWN")));
    }

    @Test
    public void toggleHealthCheckMaintenanceMode_MaintenanceModeIsSet_Passes() throws Exception {

        when(mockHealthCheckDetailService.isHealthy()).thenReturn(true);

        mockMvc.perform(get("/healthcheck?maintenance=true"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("MAINTENANCE")));
        mockMvc.perform(get("/healthcheck?maintenance=false"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("OK")));
    }

}