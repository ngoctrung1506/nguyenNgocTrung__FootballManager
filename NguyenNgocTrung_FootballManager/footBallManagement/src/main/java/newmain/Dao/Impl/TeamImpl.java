package newmain.Dao.Impl;

import newmain.Dao.TeamDAO;
import newmain.Model.Team;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 10/06/2017.
 */
@Repository
public class TeamImpl implements TeamDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    @Override
    public Team findByID(int id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        Team p = (Team) session.load(Team.class, new Integer(id));
        return p;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Team> findAll()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<Team> personsList = session.createQuery("from Team").list();
        return personsList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Team> findAllTeambyLeagueId(int id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "FROM Team team WHERE team.league.id = "+ id;
        List<Team> personsList = session.createQuery(hql).list();
        return personsList;
    }

    @Override
    public void updateTeam(Team team) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "UPDATE Team set name = :name,numberOfDraw =:numberOfDraw, " +
                "numberOfLost =:numberOfLost, score =:score," +
                " logo =:logo, numberOfWin =:numberOfWin  WHERE id = :id";

        Query query = session.createQuery(hql);
        query.setParameter("name",team.getName());
        query.setParameter("numberOfDraw", team.getNumberOfDraw());
        query.setParameter("numberOfLost", team.getNumberOfLost());
        query.setParameter("numberOfWin", team.getNumberOfWin());
        query.setParameter("score", team.getScore());
        query.setParameter("logo", team.getLogo());
        query.setParameter("id", team.getId());
        query.executeUpdate();
    }

    @Override
    public void removeTeam(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Team team = (Team) session.load(Team.class, new Integer(id));
        if (null != team) {
            session.delete(team);
        }
    }

    @Override
    public void addTeam(Team p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
    }
}
