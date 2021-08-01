package dao;

import org.hibernate.Session;  
import org.hibernate.Transaction;  
import entity.HibernateUtil;  
import entity.User;  
  
public class UserDAOImpl implements UserDAO {  
  

    @Override  
    public void save(User user) {  


        Session session = HibernateUtil.getsSession();  

        Transaction tx = session.beginTransaction();  
        try {  

            session.save(user);  

            tx.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  

            tx.rollback();  
        } finally {  

            HibernateUtil.closeSession();  
        }  
    }  

    @Override  
    public User findById(int id) {  
        // TODO Auto-generated method stub  
        User user = null;  
        Session session = HibernateUtil.getsSession();  
        Transaction tx = session.beginTransaction();  
        try {  

            user = (User) session.get(User.class, id);  
            tx.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
            tx.rollback();  
        } finally {  
            HibernateUtil.closeSession();  
        }  
        return user;  
    }  
  

    @Override  
    public void delete(User user) {  

        Session session = HibernateUtil.getsSession();  
        Transaction tx = session.beginTransaction();  
        try {  
           //deleta
            session.delete(user);  
            tx.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
            tx.rollback();  
        } finally {  
            HibernateUtil.closeSession();  
        }  
    }  
  

    @Override  
    public void update(User user) {  
        // TODO Auto-generated method stub  
        Session session = HibernateUtil.getsSession();

        Transaction tx = session.beginTransaction();
        try {  
           //atualiza
            session.update(user);  
            tx.commit();  
        } catch (Exception e) {  
            tx.rollback();  
            e.printStackTrace();  
        } finally {  
            HibernateUtil.closeSession();  
        }  
    }  
  
}  
