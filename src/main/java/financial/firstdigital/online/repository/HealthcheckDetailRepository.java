package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.HealthcheckDetail;
import org.springframework.data.repository.CrudRepository;

public interface HealthcheckDetailRepository extends CrudRepository<HealthcheckDetail, Integer> {

    public HealthcheckDetail findDistinctByHealthcheckId(int healthcheckId);

}
