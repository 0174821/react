package cn.jxufe.db.service;

import cn.jxufe.db.domain.user;

public interface userservice {
	/**
	 * 用户登录，成功返回用户信息，失败返回null
	 * @param username
	 * @param password
	 * @return
	 */
	public user login(String username,String password);
	public void addUser(user user);
	public void recharge(user user, float number);
}