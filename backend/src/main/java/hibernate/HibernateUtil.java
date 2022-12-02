package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import negocio.Persona;

public class HibernateUtil {
	
    private static SessionFactory sessionFactory;
    private HibernateUtil() {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
        	 config.addAnnotatedClass(Persona.class);
             sessionFactory = config.buildSessionFactory(); 
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
    	if (sessionFactory == null) {
    		new HibernateUtil();
    	}
        return sessionFactory;
    }
	

}
