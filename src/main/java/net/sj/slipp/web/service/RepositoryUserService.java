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
	
	
}
