package entity;

import org.hibernate.HibernateException;  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.cfg.Configuration; 

public class HibernateUtil {  
	  
    private static SessionFactory sessionFactory;  

    private static final ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();  

    static  
    {  
        try  
        {  

            Configuration cfg=new Configuration().configure();  

            sessionFactory=cfg.buildSessionFactory();  
        }catch(Throwable ex)  
        {  
            throw new ExceptionInInitializerError(ex);  
        }  
    }  

    public static SessionFactory getsSessionFactory()  
    {  
        return sessionFactory;  
    }  

    public static Session getsSession() throws HibernateException  
    {  
        Session session=(Session) threadLocal.get();  
        if(session==null||!session.isOpen())  
        {  
            if(sessionFactory==null)  
            {  
                rebuildSessionFactory();  
            }  

            session=(sessionFactory!=null)?sessionFactory.openSession():null;  

            threadLocal.set(session);  
        }  
        return session;  
    }  
   //sessão
    public static void closeSession()  
    {  

        Session session=(Session)threadLocal.get();  
        threadLocal.set(null);  
        if(session!=null)  
        {  
            session.close();  
        }  
    }  

    public static void rebuildSessionFactory()  
    {  
        Configuration configuration=new Configuration();  
        configuration.configure("/hibernate.cfg.xml");  
        sessionFactory=configuration.buildSessionFactory();  
    }  

    public static void shutdown()  
    {  
        getsSessionFactory().close();  
    }  
}  