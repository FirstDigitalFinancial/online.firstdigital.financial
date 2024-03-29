package financial.firstdigital.online.controller;

import financial.firstdigital.online.service.database.HealthCheckDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;

@RestController
public class HealthCheckController {

    private static final Logger logger =
            LoggerFactory.getLogger(HealthCheckController.class);

    private final AtomicBoolean maintenanceModeEnabled = new AtomicBoolean();

    HealthCheckDetailService healthCheckDetailService;

    @Autowired
    public void setHealthCheckDetailService(HealthCheckDetailService healthCheckDetailService) {
        this.healthCheckDetailService = healthCheckDetailService;
    }

    public HealthCheckController() {

    }

    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    public ResponseEntity<String> healthCheck(
            @RequestParam(value = "maintenance", required = false) final String maintenanceMode) throws Exception {
        toggleMaintenanceMode(maintenanceMode);

        if (maintenanceModeEnabled.get()) {
            return new ResponseEntity<>("MAINTENANCE", HttpStatus.OK);
        } else if (isHealthy()) {
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("DOWN", HttpStatus.OK);
        }
    }

    private boolean isHealthy() {

        boolean allIsHealthy;

        try {
            allIsHealthy = healthCheckDetailService.isHealthy();
        } catch (Exception e) {
            allIsHealthy = false;
        }

        return allIsHealthy;
    }

    private void toggleMaintenanceMode(final String maintenanceMode) throws Exception {
        if ("true".equalsIgnoreCase(maintenanceMode) || "false".equalsIgnoreCase(maintenanceMode)) {

            logger.info("Setting maintenanceMode to " + maintenanceMode);

            maintenanceModeEnabled.set(Boolean.valueOf(maintenanceMode));

        }
    }


}
