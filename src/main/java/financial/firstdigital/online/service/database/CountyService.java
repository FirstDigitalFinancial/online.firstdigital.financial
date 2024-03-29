package financial.firstdigital.online.service.database;

import financial.firstdigital.online.model.County;

/**
 * The CountyService interface
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-17
 */

public interface CountyService {

    public County findDistinctByCountyIdEquals(int countyId);
    public County findDistinctByCountyNameEquals(String countyName);

}
