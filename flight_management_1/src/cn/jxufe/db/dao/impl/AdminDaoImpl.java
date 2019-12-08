package cn.jxufe.db.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.jxufe.db.dao.AdminDao;
import cn.jxufe.db.dao.resultSetHandler.AirPlaneResultSetHandler;
import cn.jxufe.db.domain.customer;
import cn.jxufe.db.domain.flight;
import cn.jxufe.db.domain.orderdetail;
import cn.jxufe.db.domain.plane;
import cn.jxufe.db.domain.user;
import cn.jxufe.db.util.DaoUtils;



public class AdminDaoImpl implements AdminDao{
	private static final String QUERY_ALL_AIRPLANE="select * from PLANE";
	@Override
	public List<plane> queryAllPlane() {
		List<plane> airPlanes=null;
		QueryRunner runner =new QueryRunner(DaoUtils.getSource());
		try {
			airPlanes = runner.query(QUERY_ALL_AIRPLANE, new AirPlaneResultSetHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return airPlanes;
	}

	@Override
	public void insertPlane(plane airPlane) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePlane(String planeno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePlane(String planeno, plane newplane) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<flight> queryAllFlight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertFlight(flight flight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFlight(String flightno, flight newflight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFlight(String flightno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<user> queryUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(user user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String userno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(String userno, user user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<orderdetail> queryAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrderdetail(orderdetail orderdetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrderdetail(String orderdetailno, orderdetail orderdetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderdetail(String orderdetailno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<customer> queryCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCustomers(customer cosCustomer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomers(String customerno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomers(String customerno, customer cosCustomer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExistsByPlaneno(String planeno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExistsByflightno(String flightno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExistsByUserno(String userno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExistsByDetailsno(String detailsno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExistsByCustomerno(String customerno) {
		// TODO Auto-generated method stub
		return false;
	}

	

	
}
