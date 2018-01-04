package financial.firstdigital.online.service.database;

import financial.firstdigital.online.model.Title;

/**
 * The TitleService interface
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-17
 */

public interface TitleService {
    public Title findDistinctByTitleIdEquals(int titleId);
    public Title findDistinctByTitleEquals(String title);
}
