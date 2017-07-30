package net.sj.slipp.web.service;

import java.util.List;

import net.sj.slipp.web.domain.User;

public interface UserService {

	public List<User> findAll();
	public void addNewUser(User newUser);


}
