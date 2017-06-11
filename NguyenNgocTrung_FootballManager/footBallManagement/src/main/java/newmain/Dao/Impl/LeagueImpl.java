package newmain.Dao.Impl;

import newmain.Dao.LeagueDAO;
import newmain.Model.League;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 11/06/2017.
 */
@Repository
public class LeagueImpl implements LeagueDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    @Override
    public League findByID(int id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        League p = (League) session.load(League.class, new Integer(id));
        return p;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<League> findAll()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<League> personsList = session.createQuery("from League").list();
        return personsList;
    }

    @Override
    public void updateLeague(League League) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(League);
    }

    @Override
    public void removeLeague(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        League League = (League) session.load(League.class, new Integer(id));
        if (null != League) {
            session.delete(League);
        }
    }

    @Override
    public void addLeague(League p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
    }
}
