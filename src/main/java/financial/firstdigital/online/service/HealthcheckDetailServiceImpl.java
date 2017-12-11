package financial.firstdigital.online.service;

import financial.firstdigital.online.model.HealthcheckDetail;
import financial.firstdigital.online.repository.HealthcheckDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("healthcheckDetailService")
@Transactional
public class HealthcheckDetailServiceImpl implements HealthcheckDetailService {

    @Autowired
    HealthcheckDetailRepository healthcheckDetailRepository;

    public boolean isHealthy() {
        return healthcheckDetailRepository.findDistinctByHealthcheckId(1).getHealthcheck();
    }

}
