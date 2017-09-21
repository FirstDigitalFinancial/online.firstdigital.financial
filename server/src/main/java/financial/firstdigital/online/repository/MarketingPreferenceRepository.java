package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.MarketingPreferenceDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * The MarketingPreferenceRepository class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-20
 */

public interface MarketingPreferenceRepository extends CrudRepository<MarketingPreferenceDetail, Long> {
    public MarketingPreferenceDetail getDistinctByMarketingPreferenceIdEquals(int marketingPreferenceId);
}
