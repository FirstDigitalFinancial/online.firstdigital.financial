package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.County;
import org.springframework.data.repository.CrudRepository;

public interface CountyRepository extends CrudRepository<County, Long> {
    public County findDistinctByCountyIdEquals(int countyId);
}
