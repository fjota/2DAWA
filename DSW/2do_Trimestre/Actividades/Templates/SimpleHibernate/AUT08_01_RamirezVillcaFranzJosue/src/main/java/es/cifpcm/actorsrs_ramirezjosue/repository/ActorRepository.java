package es.cifpcm.actorsrs_ramirezjosue.repository;

import es.cifpcm.actorsrs_ramirezjosue.data.HibernateUtil;
import es.cifpcm.actorsrs_ramirezjosue.model.Actor;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaQuery;

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

      CriteriaQuery<Actor> criteriaQuery = session.getCriteriaBuilder().createQuery(Actor.class);
      criteriaQuery.from(Actor.class);
      list = session.createQuery(criteriaQuery).getResultList();
      
      session.getTransaction().commit();
    } catch (Exception ex) {
      session.getTransaction().rollback();
    } finally {
      session.close();
    }

    return list;
  }

}
