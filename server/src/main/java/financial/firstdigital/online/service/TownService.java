package financial.firstdigital.online.service;

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
}
