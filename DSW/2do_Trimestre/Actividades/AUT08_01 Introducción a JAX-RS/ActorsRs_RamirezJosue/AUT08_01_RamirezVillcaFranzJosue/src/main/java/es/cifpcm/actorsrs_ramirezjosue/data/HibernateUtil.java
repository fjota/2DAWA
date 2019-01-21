package es.cifpcm.actorsrs_ramirezjosue.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Josué Ramírez
 */
public class HibernateUtil {

  private static final SessionFactory sessionFactory;

  static {

    try {
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
              applySettings(configuration.getProperties());

      sessionFactory = configuration.buildSessionFactory(builder.build());

    } catch (Throwable ex) {
      // Log the exception. 
      System.err.println("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public static Session openSession() {
    return sessionFactory.openSession();
  }
}
