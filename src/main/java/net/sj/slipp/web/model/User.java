package net.sj.slipp.web.model;

import lombok.Setter;

@Setter
public class User {
	private String userId;
	private String password;
	private String userName;
	private String email;
	
	
	@Override
	public String toString() {
		return "User [" 
				+ "userId=" + userId 
				+ ", password=" + password 
				+ ", userName=" + userName 
				+ ", email=" + email
				+ "]";
	}
	
	
}
