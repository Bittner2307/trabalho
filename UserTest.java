package test;

import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class UserTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSave() {
		UserDAO userDAO=new UserDAOImpl();  
        try{  
            User u=new User();  
         //usuario
            u.setId(20);  
            u.setName("bittner");
            u.setPassword("123456");  
            u.setType("admin");  

            userDAO.save(u);  
        }catch(Exception e){  
            e.printStackTrace();  
        }
	}

	@Test
	public void testFindById() {
		fail("ainda não implementedo");
	}

	@Test
	public void testDelete() {
		fail("ainda não implementedo");
	}

	@Test
	public void testUpdate() {
		fail("ainda não implementado");
	}

}
