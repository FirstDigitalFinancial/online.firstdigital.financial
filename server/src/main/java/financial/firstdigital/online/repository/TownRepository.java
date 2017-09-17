package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.Town;
import org.springframework.data.repository.CrudRepository;

/**
 * The TownRepository class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-17
 */

public interface TownRepository extends CrudRepository<Town, Long>{
    public Town findDistinctByTownIdEquals(int townId);
}
