package com.mockito;

public class UserService {

	UsersDao dao;
	
	public UserService(UsersDao dao){
		this.dao=dao;
	}
	
	
	public String typeOfUser(Integer id) {
		Users user = dao.findUserById(id);
		
		if(user.getBalance()>0 && user.getBalance()<=30000) {
			return "New User";
		}
		else if(user.getBalance()>30000 && user.getBalance()<=40000) {
			return "Regular User";
		}
		else {
			return "Premium User";
		}
	}
}
