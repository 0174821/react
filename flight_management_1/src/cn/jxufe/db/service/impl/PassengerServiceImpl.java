package cn.jxufe.db.service.impl;
import java.sql.Date;
import java.util.List;

import cn.jxufe.db.dao.PassengerDao;
import cn.jxufe.db.domain.customer;
import cn.jxufe.db.domain.flightclass;
import cn.jxufe.db.domain.orderdetail;
import cn.jxufe.db.domain.ordermaster;
import cn.jxufe.db.domain.seat;
import cn.jxufe.db.domain.tank;
import cn.jxufe.db.domain.user;

import com.sun.org.apache.bcel.internal.generic.NEW;


public class PassengerServiceImpl implements PassengerService{
	PassengerDao aDao=new PassengerDaoImpl();
	@Override
	public List<flightclass> findFlightByStartAndDist(String start,String dist,Date godate)
	{
		List<flightclass> flightByStartAndDist=aDao.findFlightByStartAndDist(start, dist,godate);
		return aDao.flightByStartAndDist(start,dist,godate);
	}
	@Override
	public List<tank> findtank(flightclass flightclass)
	{
		List<tank> tank=aDao.findtank(flightclass);
		return aDao.tank(flightclass);
	}
	public ordermaster creatOrdermaster(flightclass flightclass,user user)
	{
		return aDao.creatOrdermaster(flightclass,user);
	}
	public boolean creatOrderdetail(flightclass flightclass, tank tank, ordermaster ordermaster,customer customer)
	{
		return aDao.creatOrderdetail(flightclass,tank,ordermaster,customer);
	}
	public List<orderdetail> qrydetailBymaster(ordermaster ordermaster)
	{
		List<orderdetail> detailBymater=aDao.(ordermaster);
		return aDao.detailBymaster(ordermaster);
	}
	public boolean delOrderdetail(orderdetail orderdetail) 
	{
		
	}
	public boolean delwholeOrder(ordermaster ordermaster) {
		
	}
	public List<orderdetail> qrydetailByCustomer(customer customer) 
	{
		List<orderdetail> detailByCustomerList=a.Dao(customer);
		return aDao.detailByCustomer;
	}
	public List<seat> findOkseat(orderdetail orderdetail)
	{
		List<seat> okseat=aDao.findOkseat(orderdetail);
		return aDao.okseat(ordertail);
	}
	public boolean selectSeat(seat seat, orderdetail orderdetail)
	{
		
	}
	public boolean delSeat(orderdetail orderdetail)
	{
		
	}
}