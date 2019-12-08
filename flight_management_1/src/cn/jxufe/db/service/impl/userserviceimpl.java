package cn.jxufe.db.service.impl;


import cn.jxufe.db.dao.userdao;
import cn.jxufe.db.dao.impl.userdaoImpl;
import cn.jxufe.db.domain.user;
import cn.jxufe.db.service.userservice;


public class userserviceimpl implements userservice{

	public user login(String username, String password) {
		userdao uDao=new userdaoImpl();
		return uDao.login(username, password);
	}

	public void addUser(user user) {
		// TODO Auto-generated method stub
		
	}

	public void recharge(user user, float number) {
		// TODO Auto-generated method stub
		
	}

	

}
