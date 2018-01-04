package financial.firstdigital.online.service.database;

import financial.firstdigital.online.model.MarketingPreferenceDetail;

/**
 * The MarketingPreferenceService interface
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-16
 */

public interface MarketingPreferenceService {
    public void saveMarketingPreferenceDetail(MarketingPreferenceDetail marketingPreferenceDetail);
    public MarketingPreferenceDetail findDistinctByMarketingPreferenceIdEquals(Long marketingPreferenceId);
}
