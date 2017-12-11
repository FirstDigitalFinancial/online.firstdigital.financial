package financial.firstdigital.online.service;

import financial.firstdigital.online.repository.HealthCheckDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("healthCheckDetailService")
@Transactional
public class HealthCheckDetailServiceImpl implements HealthCheckDetailService {

    @Autowired
    HealthCheckDetailRepository healthCheckDetailRepository;

    public boolean isHealthy() {
        return healthCheckDetailRepository.findDistinctByHealthCheckId(1).getHealthCheck();
    }

}
