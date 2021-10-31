package tn.esprit.spring.services;

import java.util.List;


import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;
import org.apache.logging.log4j.LogManager;



@Service
public class UserServiceImpl implements IUserService {

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	
	@Autowired
	UserRepository userRepository;

		
	
	// TODO Logger à ajouter  
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		//try {
	
			logger.info("In Method retrieveAllUsers"); 
			users = (List<User>) userRepository.findAll();
			logger.debug("connexion à la DB OK");
			int i = 1/0;
			for (User user : users) {
				logger.debug("user :" + user.getLastName());   
			} 
			logger.debug("Out of Method retrieveAllUsers with Success");
		/*}catch (Exception e) {
			// TODO Log à ajouter pour gérer les erreurs 
		}*/

		return users;
	}


	@Override
	public User addUser(User u) {
		logger.info("In Method addUser :");
		User u_saved = userRepository.save(u); 
		logger.info("Out of Method addUser :");
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		logger.info("In Method updateUser :");
		User u_saved = userRepository.save(u); 
		logger.info("Out Method updateUser :");
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		logger.info("In Method deleteUser :");
		userRepository.deleteById(Long.parseLong(id)); 
		logger.info("Out Method deleteUser :"); 
	}

	@Override
	public User retrieveUser(String id) {
		logger.info("In Method retrieveUser :"); 
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		logger.info("Out Method retrieveUser :"); 
		return u; 
	}

}
