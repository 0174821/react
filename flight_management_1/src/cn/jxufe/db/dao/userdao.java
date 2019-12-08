package cn.jxufe.db.dao;

import cn.jxufe.db.domain.user;

public interface userdao {
	/**
	 * 根据用户名密码检查登录，若查询到用户则返回该用户信息，若无结果返回null。
	 * @param username
	 * @param password
	 * @return
	 */
	public user login(String userno,String password);
	
	public void insertUser(user user);

	public void reCharge(user user, float number); 

}