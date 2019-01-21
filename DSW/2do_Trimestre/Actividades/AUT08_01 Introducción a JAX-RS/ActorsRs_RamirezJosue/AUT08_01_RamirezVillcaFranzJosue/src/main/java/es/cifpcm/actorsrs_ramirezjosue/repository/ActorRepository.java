package es.cifpcm.actorsrs_ramirezjosue.repository;

import es.cifpcm.actorsrs_ramirezjosue.data.HibernateUtil;
import es.cifpcm.actorsrs_ramirezjosue.model.Actor;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Josué Ramírez
 */
public class ActorRepository {

  public static List<Actor> getAll() {
    List<Actor> list = new ArrayList<>();
    Session session = HibernateUtil.getSessionFactory().openSession();

    try {
      session.beginTransaction();

      Criteria criteria = session.createCriteria(Actor.class);
      list.add((Actor) criteria.uniqueResult());
      /*for (Object object : criteria.list()) {
        list.add((Actor) object);
      }*/
      //list.addAll(criteria.list());
      session.getTransaction().commit();
    } catch (Exception ex) {
      session.getTransaction().rollback();
    } finally {
      session.close();
    }

    return list;
  }
  

}
