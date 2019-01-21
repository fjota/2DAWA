package es.cifpcm.actorsrs_ramirezjosue.repository;

import es.cifpcm.actorsrs_ramirezjosue.data.HibernateUtil;
import es.cifpcm.actorsrs_ramirezjosue.model.Actor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.Response;

/**
 *
 * @author Josué Ramírez
 */
public class ActorRepository {

  public static List<Actor> findAll() {
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

  public static Actor findOne(int id) {
    Actor actor = new Actor();
    Session session = HibernateUtil.getSessionFactory().openSession();

    try {
      session.beginTransaction();

      CriteriaQuery<Actor> criteriaQuery = session.getCriteriaBuilder().createQuery(Actor.class);
      Root<Actor> actorRoot = criteriaQuery.from(Actor.class);
      criteriaQuery.where(session.getCriteriaBuilder().equal(actorRoot.get("actorId"), id));
      actor = session.createQuery(criteriaQuery).getSingleResult();
      
      session.getTransaction().commit();
    } catch (Exception ex) {
      session.getTransaction().rollback();
    } finally {
      session.close();
    }

    return actor;
  }
  
  public static Response registerActor(String name, String lastName){
    Session session = HibernateUtil.getSessionFactory().openSession();

    try {
      session.beginTransaction();

      Actor actor = new Actor(name, lastName, new Date());
      session.save(actor);
      
      session.getTransaction().commit();
    } catch (Exception ex) {
      session.getTransaction().rollback();
      Response.serverError().entity("Actor id not found").build();
    } finally {
      session.close();
    }
    
    return Response.ok("Success").build();
  }

}
