package tn.esprit.spring.services;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;




import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;





@SpringBootTest
public class UserServiceImplTest {
	
@Autowired
IUserService us;

@Test
@Order(1)
public void testRetrieveAllUsers() {
	List<User> listUsers = us.retrieveAllUsers();
	Assertions.assertEquals(1, listUsers.size());
}

@Test
@Order(2)
public void testAddUser() throws ParseException {
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
Date d = dateFormat.parse("2021-03-23");
User u = new User("Nader","Nader",d,Role.INGENIEUR);
User userAdded= us.addUser(u);
Assertions.assertEquals(u.getLastName(),userAdded.getLastName());
}
		
@Test
@Order(3)
public void testModifyUser() throws ParseException{

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date d = dateFormat.parse("2021-03-23");
	User u = new User(2L,"Nader11","Nader",d,Role.INGENIEUR);
	User userUpdated = us.updateUser(u);
	Assertions.assertEquals(u.getLastName(), userUpdated.getLastName());
}




@Test
@Order(4)
public void testDeleteUser() {
	us.deleteUser("5");
	Assertions.assertNull(us.retrieveUser("4"));
		
}
	
}
