package financial.firstdigital.online.service;

import financial.firstdigital.online.model.Town;
import financial.firstdigital.online.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * The TownServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-17
 */

@Service("townService")
@Transactional
public class TownServiceImpl implements TownService {

    @Autowired
    TownRepository townRepository;

    public Town findDistinctByTownIdEquals(int townId) {
        return townRepository.findDistinctByTownIdEquals(townId);
    }

    public Town findDistinctByTownNameEquals(String townName) {
        return townRepository.findDistinctByTownNameEquals(townName);
    }

}
