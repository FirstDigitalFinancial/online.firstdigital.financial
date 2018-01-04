package financial.firstdigital.online.service.database;

import financial.firstdigital.online.model.County;
import financial.firstdigital.online.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("countyService")
@Transactional
public class CountyServiceImpl implements CountyService {

    @Autowired
    CountyRepository countyRepository;

    public County findDistinctByCountyIdEquals(int countyId) {
        return countyRepository.findDistinctByCountyIdEquals(countyId);
    }

    public County findDistinctByCountyNameEquals(String countyName) {
        return countyRepository.findDistinctByCountyNameEquals(countyName);
    }

}
