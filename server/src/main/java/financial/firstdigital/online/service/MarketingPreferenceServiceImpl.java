package financial.firstdigital.online.service;

import financial.firstdigital.online.model.MarketingPreferenceDetail;
import financial.firstdigital.online.repository.MarketingPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * The MarketingPreferenceServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-20
 */

@Service("marketingPreferenceService")
@Transactional
public class MarketingPreferenceServiceImpl implements MarketingPreferenceService {

    @Autowired
    MarketingPreferenceRepository marketingPreferenceRepository;

    public void saveMarketingPreferenceDetail(MarketingPreferenceDetail marketingPreferenceDetail) {
        marketingPreferenceRepository.save(marketingPreferenceDetail);
    }
    public MarketingPreferenceDetail getDistinctByMarketingPreferenceIdEquals(int marketingPreferenceId) {
        return marketingPreferenceRepository.getDistinctByMarketingPreferenceIdEquals(marketingPreferenceId);
    }

}