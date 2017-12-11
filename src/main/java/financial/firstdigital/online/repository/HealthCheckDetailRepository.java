package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.HealthCheckDetail;
import org.springframework.data.repository.CrudRepository;

public interface HealthCheckDetailRepository extends CrudRepository<HealthCheckDetail, Integer> {

    public HealthCheckDetail findDistinctByHealthCheckId(int healthCheckId);

}
