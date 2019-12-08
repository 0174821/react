package cn.jxufe.db.service;

import java.sql.Date;
import java.util.List;

import cn.jxufe.db.domain.customer;
import cn.jxufe.db.domain.flightclass;
import cn.jxufe.db.domain.orderdetail;
import cn.jxufe.db.domain.ordermaster;
import cn.jxufe.db.domain.seat;
import cn.jxufe.db.domain.tank;
import cn.jxufe.db.domain.user;

public interface PassengerService {
			
	
		//设置舱等，座位，并返回订单明细
		public orderdetail setOrderdetail(user user,tank tank,seat seat,customer customer);
		
		
		//查询订单订购的所有机票
		public void getAllticket(user user,ordermaster ordermaster);
		
		//取消已经订购的机票
		public void cancleticket(ordermaster ordermaster,orderdetail orderdetail);
	
}
