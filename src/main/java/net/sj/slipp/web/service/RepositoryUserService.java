package net.sj.slipp.web.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sj.slipp.web.domain.User;
import net.sj.slipp.web.repository.UserRepository;

@Service
public class RepositoryUserService implements UserService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	public RepositoryUserService(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<User> findAll(){
		logger.debug("Finding all user lists");
		List<User> users=repository.findAll();
		
		return users;
	}
	
	@Override
	public void addNewUser(User newUser){
		logger.debug("Adding a new user with information: {}", newUser);
		repository.save(newUser);
	}
	
	@Override
	public User findById(Long id){
		
		User user = repository.findOne(id);
		logger.debug("Found a user info with id in repository: {}", id, user);
		
		return user;
	}
	
	@Override
	public void updateById(Long id,User updatedUser) {
		logger.debug("finding user with id to update:", id);
		User user=repository.findOne(id);
		logger.debug("finded a user: {}", user);
		
		user.update(updatedUser);
		logger.debug("updated userr: {}", user);
		repository.save(user);
	}
	
}
