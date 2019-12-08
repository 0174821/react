package cn.jxufe.db.service;

import java.util.List;

import cn.jxufe.db.domain.customer;
import cn.jxufe.db.domain.flight;
import cn.jxufe.db.domain.orderdetail;
import cn.jxufe.db.domain.plane;
import cn.jxufe.db.domain.user;

public interface AdminService {
	public List<plane> queryAllPlane();
	public void insertPlane(plane airPlane);
	public void deletePlane(String planeno);
	public void updatePlane(String planeno,plane newplane);
	
	public List<flight> queryAllFlight();
	public void insertFlight(flight flight);
	public void updateFlight(String flightno,flight newflight);
	public void deleteFlight(String flightno);

	public List<user> queryUsers();
	public void insertUser(user user);
	public void deleteUser(String userno);
	public void updateUser(String userno,user user);

	public List<orderdetail> queryAllOrder();
	public void insertOrderdetail(orderdetail orderdetail);
	public void updateOrderdetail(String orderdetailno,orderdetail orderdetail);
	public void deleteOrderdetail(String orderdetailno);
	
	public List<customer> queryCustomers();
	public void insertCustomers(customer cosCustomer);
	public void deleteCustomers(String customerno);
	public void updateCustomers(String customerno,customer cosCustomer);

}
