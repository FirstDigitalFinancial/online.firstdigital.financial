package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.Title;
import org.springframework.data.repository.CrudRepository;

/**
 * The TitleDetailRepository class
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-17
 */

public interface TitleDetailRepository extends CrudRepository<Title, Long> {
    public Title findDistinctByTitleIdEquals(int titleId);
    public Title findDistinctByTitleEquals(String title);
}
