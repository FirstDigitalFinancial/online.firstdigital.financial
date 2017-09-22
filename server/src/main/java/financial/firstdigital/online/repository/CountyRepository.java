package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.County;
import org.springframework.data.repository.CrudRepository;

/**
 * The CountyRepository class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-17
 */

public interface CountyRepository extends CrudRepository<County, Long> {
    public County findDistinctByCountyIdEquals(int countyId);
    public County findDistinctByCountyNameEquals(String countyName);
}
