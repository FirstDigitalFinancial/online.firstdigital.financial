package financial.firstdigital.online.service;

import financial.firstdigital.online.model.Title;
import financial.firstdigital.online.repository.TitleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * The TitleServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-17
 */

@Service("titleService")
@Transactional
public class TitleServiceImpl implements TitleService {

    @Autowired
    TitleDetailRepository titleDetailRepository;

    @Override
    public Title findDistinctByTitleIdEquals(int titleId) {
        return titleDetailRepository.findDistinctByTitleIdEquals(titleId);
    }

    @Override
    public Title findDistinctByTitleEquals(String title) {
        return titleDetailRepository.findDistinctByTitleEquals(title);
    }


}
