package newmain.Dao.Impl;

import newmain.Dao.PlayerDAO;
import newmain.Model.Player;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 12/06/2017.
 */
@Repository
public class PlayerImpl implements PlayerDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    @Override
    public Player findByID(int id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        Player p = (Player) session.load(Player.class, new Integer(id));
        return p;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Player> findAll()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<Player> personsList = session.createQuery("from Player").list();
        return personsList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Player> findAllPlayerbyLeagueId(int id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "FROM Player player WHERE player.id = "+ id;
        List<Player> personsList = session.createQuery(hql).list();
        return personsList;
    }

    @Override
    public void updatePlayer(Player player) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "UPDATE Player set name = :name,position =:position, " +
                "goal =:goal, age =:age WHERE id = :id";

        Query query = session.createQuery(hql);
        query.setParameter("name",player.getName());
        query.setParameter("position", player.getPosition());
        query.setParameter("goal", player.getGoal());
        query.setParameter("age", player.getAge());
        query.setParameter("id", player.getId());
        query.setParameter("id", player.getId());
        query.executeUpdate();
    }

    @Override
    public void removePlayer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Player player = (Player) session.load(Player.class, new Integer(id));
        if (null != player) {
            session.delete(player);
        }
    }

    @Override
    public void addPlayer(Player p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
    }
}
