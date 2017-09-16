package financial.firstdigital.online.dao;

import financial.firstdigital.online.model.AccountDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The AbstractDAO class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-16
 */
public abstract class AbstractDAO {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void persist(AccountDetail entity) { getSession().persist(entity);}
    public void update(AccountDetail entity) { getSession().update(entity);}

    public void delete(Object entity) {
        getSession().delete(entity);
    }

}
