package financial.firstdigital.online.service;

import financial.firstdigital.online.model.Title;

/**
 * The TitleService interface
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-17
 */

public interface TitleService {
    public Title findDistinctByTitleIdEquals(int titleId);
}
