package Dao.Impl;

import DTO.TeamDTO;
import Dao.TeamDAO;
import Model.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Admin on 02/06/2017.
 */
public class TeamImpl implements TeamDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    @Override
    public TeamDTO findByID(int id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        TeamDTO p = (TeamDTO) session.load(TeamDTO.class, new Integer(id));
        return p;
    }

    @Override
    public List<TeamDTO> findAll()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<TeamDTO> personsList = session.createQuery("from Team").list();
        return personsList;
    }

}
