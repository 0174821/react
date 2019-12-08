package cn.jxufe.db.dao;

import java.sql.Date;
import java.util.List;

import cn.jxufe.db.domain.customer;
import cn.jxufe.db.domain.flightclass;
import cn.jxufe.db.domain.orderdetail;
import cn.jxufe.db.domain.ordermaster;
import cn.jxufe.db.domain.seat;
import cn.jxufe.db.domain.tank;
import cn.jxufe.db.domain.user;

public interface PassengerDao {	
//	/**
//	 * 根据出发地和目的地查询航班。
//	 * @param start
//	 * @param dist
//	 * @return 返回Flight表，若发生错误返回null
//	 */
//	public List<Flight> findFlightByStartAndDist(String start,String dist);
//	
//	/**
//	 * 订机票
//	 * @param user
//	 * @param flight
//	 * @throws Exception
//	 */
//	public void bookFlight(User user,Flight flight) throws FMException;
//	/**
//	 * 取消订单
//	 * @param order
//	 */
//	public void bounce(Order order) throws FMException;
//	/**
//	 * 用户付款
//	 * @param user
//	 * @param flight
//	 */
//	public void payFlight(Order order) throws FMException;
//	/**
//	 * 获取用户的订单列表
//	 * @param user
//	 * @return
//	 */
//	public List<Order> getOrderListOfUser(User user);
//	/**
//	 * 获取用户已付款的订单列表
//	 * @param user
//	 * @return
//	 */
//	public List<Order> getPayedOrderListOfUser(User user);
//	/**
//	 * 获取用户未付款的订单列表
//	 * @param user
//	 * @return
//	 */
//	public List<Order> getUnPayedOrderListOfUser(User user);
//	
//	public List<Flight> getUnBookedFlight(User user);
//	
//	public Order getOrder(Order order);
	/**方法一，查询所有航班，需要从前台取得用户输入的时间，出发地，目的地，最终得到“航班班次”列表提供用户选择**/
	public List<flightclass> findFlightByStartAndDist(String start,String dist,Date godate);
	
	/**方法二(1)，在前台取用户具体选择的“航班班次”后，返回该航班对应的所有舱等列表提供用户选择**/
	public List<tank> findtank(flightclass flightclass);
	
	/***方法二(2),与方法二(1)同时，在前台取用户具体选择的航班班次列后，方法内自动生成一个主订单号并返回“主订单”
	其中属性：订单状态置2(未支付)，机票总数置0，支付总金额置0**/       
	public ordermaster creatOrdermaster(flightclass flightclass,user user);/**补：还需要从前台获取当前账号的用户**/
	
	/**方法三，前台取得用户选择的“舱等”后，随机为其分配座位(伪分配，订单明细的座位号外码置null)，此步不需要写方法**/
	/**方法四，将刚才所得“航班班次”，“舱等”，以及“主订单”订单的所有信息作为方法四参数，方法内生成订单明细号 ，
	 订单明细属性设置为：票价：从前台获取其付款数同时更新其主订单中的属性：机票总数+1，支付总金额+该订单明细的价格，单状态置1(已付款)**/
	public boolean creatOrderdetail(flightclass flightclass,tank tank,ordermaster ordermaster,customer customer); 
	/**改:现布朗性确认返回,补：还需要从前台读入这张票具体是为谁办的**/
	
	/**方法五，查询当前订单下订单下的所有订单明细，并返回订单明细列**/
	public List<orderdetail> qrydetailBymaster(ordermaster ordermaster);
	
	/**方法六，取消订单明细，参数输入为刚刚查询前台获取的订单明细，并反向操作方法四**/
	public boolean delOrderdetail(orderdetail orderdetail);   /**改:现为布朗性确认返回**/
	
	/**方法七，取消订单，参数输入为主订单，删除该主订单所有级联相关内容**/
	public boolean delwholeOrder(ordermaster ordermaster); /**改:现为布朗性确认返回**/
	
	/**方法八(1)，可选座位表提供，从前台获取当前账号所属的"乘客"，并根据乘客信息，返回当属该乘客的订单明细列**/
	public List<orderdetail> qrydetailByCustomer(customer customer);
	
	/**方法八(2)，从前台获取用户点击自己所属且想要选座的“订单明细”，并返回当前所还可选的所有“座位”给前台准备以图形界面形式供用户选择**/
	public List<seat> findOkseat(orderdetail orderdetail);
	
	/**方法九，选座，为订单明细指定用户想要的座位，需要从前台取得被选的“座位”实体，并添加为该用户订单明细下的外码进行链接
	 链接后，并把该座位的属性：出售状态置1**/
	public boolean selectSeat(seat seat,orderdetail orderdetail); /**改:现为布朗性确认返回**/
	
	/**方法十，取消选座，删除某订单明细下的外码属性：座位号, 并把被删除的座位实体的属性，出售状态重新置0**/
	public boolean delSeat(orderdetail orderdetail); /**改:现为布朗性确认返回**/
}
