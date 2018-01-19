package financial.firstdigital.online.service.database;

import financial.firstdigital.online.model.Town;

/**
 * The TownService interface
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-17
 */

public interface TownService {
    public Town findDistinctByTownIdEquals(int townId);
    public Town findDistinctByTownNameEquals(String townName);
}
