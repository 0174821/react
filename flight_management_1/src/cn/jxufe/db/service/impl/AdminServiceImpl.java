package cn.jxufe.db.service.impl;

import java.util.List;

import cn.jxufe.db.dao.AdminDao;
import cn.jxufe.db.dao.impl.AdminDaoImpl;
import cn.jxufe.db.domain.customer;
import cn.jxufe.db.domain.flight;
import cn.jxufe.db.domain.orderdetail;
import cn.jxufe.db.domain.plane;
import cn.jxufe.db.domain.user;
import cn.jxufe.db.service.AdminService;

public class AdminServiceImpl implements AdminService{
	private AdminDao aDao=new AdminDaoImpl();
	@Override
	public List<plane> queryAllPlane() {
		List<plane> planeList=aDao.queryAllPlane();
		return planeList;
	}

	@Override
	public void insertPlane(plane airPlane) {
		String planeno=airPlane.getPlaneno();
		if(planeno!=null && !"".equals(planeno) && !aDao.isExistsByPlaneno(planeno)) {
			aDao.insertPlane(airPlane);
		}
	}

	@Override
	public void deletePlane(String planeno) {
		if(planeno != null && !"".equals(planeno)&& aDao.isExistsByPlaneno(planeno)) {
			aDao.deletePlane(planeno);
		}
	}

	@Override
	public void updatePlane(String planeno, plane newplane) {
		if(planeno != null && !"".equals(planeno)&& aDao.isExistsByPlaneno(planeno)) {
			aDao.updatePlane(planeno, newplane);
		}
	}

	@Override
	public List<flight> queryAllFlight() {
		List<flight> flightList = aDao.queryAllFlight();
		return flightList;
	}

	@Override
	public void insertFlight(flight flight) {
		String flightno=flight.getFlightno();
		if(flightno!=null && !"".equals(flightno) && !aDao.isExistsByflightno(flightno)) {
			aDao.insertFlight(flight);;
		}
	}

	@Override
	public void updateFlight(String flightno, flight newflight) {
		if(flightno != null && !"".equals(flightno)&& aDao.isExistsByflightno(flightno)) {
			aDao.updateFlight(flightno, newflight);
		}
	}

	@Override
	public void deleteFlight(String flightno) {
		if(flightno != null && !"".equals(flightno)&& aDao.isExistsByflightno(flightno)) {
			aDao.deleteFlight(flightno);
		}		
	}

	@Override
	public List<user> queryUsers() {
		List<user> userList = aDao.queryUsers();
		return userList;
	}

	@Override
	public void insertUser(user user) {
		String userno=user.getUserno();
		if(userno!=null && !"".equals(userno) && !aDao.isExistsByUserno(userno)) {
			aDao.insertUser(user);
		}		
	}

	@Override
	public void deleteUser(String userno) {
		if(userno != null && !"".equals(userno)&& aDao.isExistsByUserno(userno)) {
			aDao.deleteUser(userno);
		}
	}

	@Override
	public void updateUser(String userno, user user) {
		if(userno != null && !"".equals(userno)&& aDao.isExistsByUserno(userno)) {
			aDao.updateUser(userno, user);
		}
	}

	@Override
	public List<orderdetail> queryAllOrder() {
		List<orderdetail> orderList = aDao.queryAllOrder();
		return orderList;
	}

	@Override
	public void insertOrderdetail(orderdetail orderdetail) {
		String detailsno=orderdetail.getDetailsno();
		if(detailsno!=null && !"".equals(detailsno) && !aDao.isExistsByDetailsno(detailsno)) {
			aDao.insertOrderdetail(orderdetail);
		}	
	}

	@Override
	public void updateOrderdetail(String orderdetailno, orderdetail orderdetail) {
		if(orderdetailno != null && !"".equals(orderdetailno)&& aDao.isExistsByDetailsno(orderdetailno)) {
			aDao.updateOrderdetail(orderdetailno, orderdetail);
		}
	}

	@Override
	public void deleteOrderdetail(String orderdetailno) {
		if(orderdetailno != null && !"".equals(orderdetailno)&& aDao.isExistsByDetailsno(orderdetailno)) {
			aDao.deleteOrderdetail(orderdetailno);
		}
	}

	@Override
	public List<customer> queryCustomers() {
		List<customer> customList = aDao.queryCustomers();
		return customList;
	}

	@Override
	public void insertCustomers(customer cosCustomer) {
		String customerno=cosCustomer.getCustomerno();
		if(customerno!=null && !"".equals(customerno) && !aDao.isExistsByCustomerno(customerno)) {
			aDao.insertCustomers(cosCustomer);
		}	
	}

	@Override
	public void deleteCustomers(String customerno) {
		if(customerno != null && !"".equals(customerno)&& aDao.isExistsByCustomerno(customerno)) {
			aDao.deleteCustomers(customerno);
		}
	}

	@Override
	public void updateCustomers(String customerno, customer cosCustomer) {
		if(customerno != null && !"".equals(customerno)&& aDao.isExistsByCustomerno(customerno)) {
			aDao.updateCustomers(customerno, cosCustomer);
		}		
	}
	
	
}
