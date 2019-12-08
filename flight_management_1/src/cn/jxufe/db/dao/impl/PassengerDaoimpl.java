package cn.jxufe.db.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.jxufe.db.dao.PassengerDao;
import cn.jxufe.db.domain.*;
import cn.jxufe.db.connDB.*;


public class PassengerDaoimpl implements PassengerDao{
	ConnDB connfly=new ConnDB();
//	@Override
//	public List<flightclass> findFlightByStartAndDist(String start, String dist, Date godate) {
//		List<flightclass> flightclassesList=new ArrayList<flightclass>();
//		ResultSet rs = null;
//		PreparedStatement psmt = null;
//		//String sSql="select * from FLIGHT where FLYPLACE=? AND ARRIVEPLACE= ? AND FLYTIME=?";
//		String sSql="select * "
//				+ "from FLIGHT a,FLIGHTCLASS b,PLANE c,team d,TYPE e"
//				+ "where a.FLYPLACE=? AND a.ARRIVEPLACE=? AND FLYTIME=?"
//				+ "and a.FLIGHTNO=b.FLIGHTNO and b.PLANENO=c.PLANENO and b.TEAMNO=d.TEAMNO"
//				+ "and c.PLANETYPENO=e.PLANETYPENO";
//		try {
//			/**传入参数**/
//			psmt=connfly.getConn().prepareStatement(sSql);
//			psmt.setString(1, start);
//			psmt.setString(2, dist);
//			psmt.setDate(3, godate);
//			
//			rs  = psmt.executeQuery();
//			while(rs.next())
//			{
//				flightclass flightclassOne=new flightclass();
//				
//				/**首先设置外码部分**/
//				flight flightone=new flight();
//				//外码：总航班
//				flightone.setFlightno(rs.getString(1));
//				flightone.setFlightname(rs.getString(2));
//				flightone.setFlytime(rs.getDate(3));
//				flightone.setArrivetime(rs.getDate(4));
//				flightone.setFlyplace(rs.getString(5));
//				flightone.setArriveplace(rs.getString(6));
//				flightone.setDistance(rs.getString(7));
//				
//				plane planeone=new plane();
//				//外码：飞机
//				planeone.setPlaneno(rs.getString(15));
//					//飞机外码：机型
//				type typeone=new type();
//				typeone.setTypeno(rs.getString(20));
//				typeone.setTypename(rs.getString(21));
//				
//				planeone.setSeatnum(rs.getInt(16));
//				planeone.setPlanetype(typeone);				
//				
//				
//				team teamone=new team();
//				//外码：机组
//				teamone.setTeamno(rs.getString(18));
//				teamone.setTeamname(rs.getString(19));
//				
//				
//				
//				/**外码设置完毕，开始设置本属性**/
//				flightclassOne.setFlight(flightone);
//				flightclassOne.setFlightclassno(rs.getString(9));
//				flightclassOne.setTakeoff(rs.getDate(10));
//				flightclassOne.setArrival(rs.getDate(11));
//				flightclassOne.setPlane(planeone);
//				flightclassOne.setTeam(teamone);
//				flightclassOne.setDates(rs.getDate(12));
//				flightclassesList.add(flightclassOne);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			connfly.commitConn();
//			connfly.closeConn();
//		}
//		return flightclassesList;
//	}

	@Override
	public List<tank> findtank(flightclass flightclass) {
		List<tank> tanksList=new ArrayList<tank>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		String sSql="SELECT *"
				+ "from tank a,INCLUDE b"
				+ "where a.TANKCLASSNO=b.TANKCLASSNO and b.PLANETYPENO=?";
		try {
			tank tankone=new tank();
			psmt=connfly.getConn().prepareStatement(sSql);
			psmt.setString(1, flightclass.getPlane().getPlaneno());
			rs  = psmt.executeQuery();
			while (rs.next()) {
				tankone.setTankclassno(rs.getNString(1));
				tankone.setTankclassname(rs.getString(2));
				tankone.setTankprice(rs.getInt(3));
				tanksList.add(tankone);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			connfly.commitConn();
			connfly.closeConn();
		}
		
		return tanksList;
	}

	@Override
	public ordermaster creatOrdermaster(flightclass flightclass,user user) {
		String ordermasterNo="00000001";//某种方式生成做到每次调用这个函数会生成一个新的主码
		PreparedStatement psmt = null;
		String sSql = "insert into ordermaster values(?,?,?,?,?,?,?,?)";
		//创建对象提取主订单，为传入下一个函数做参数准备
		ordermaster masterNeed=new ordermaster();
		try {
			psmt=connfly.getConn().prepareStatement(sSql);
			//初始化的主表，其中某些统计内容被初始化为0
			psmt.setString(1, ordermasterNo);
			psmt.setDate(2, null);
			psmt.setInt(3, 0);
			psmt.setInt(4, 0);
			psmt.setString(5, "2");
			psmt.setString(6, user.getUserno());
			psmt.setString(7, flightclass.getFlight().getFlightno());
			psmt.setString(8, flightclass.getFlightclassno());
			psmt.executeUpdate();
			
			masterNeed.setOrderno(ordermasterNo);
			masterNeed.setOrdertime(null);
			masterNeed.setMoney(0);
			masterNeed.setTicketsum(0);
			masterNeed.setOrderstatus("2");
			masterNeed.setUser(user);
			masterNeed.setFlightclass(flightclass);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connfly.commitConn();
			connfly.closeConn();
		}
		return masterNeed;
	}

	@Override
	public boolean creatOrderdetail(flightclass flightclass, tank tank, ordermaster ordermaster,customer customer) {
		String OrderdetailNo="00000001";//某种方式生成做到每次调用这个函数会生成一个新的主码
		PreparedStatement psmt = null;
		boolean flag=false;
		String sSql = "insert into orderdetail values(?,?,?,?,?,?,?,?)";
		try {
			psmt.setString(1, ordermaster.getOrderno());
			psmt.setString(2, OrderdetailNo);
			psmt.setInt(3,tank.getTankprice());//这里是设置飞机票价格，利用选的舱等得到价格
			psmt.setString(4, "1");//表示出售标志字符串
			psmt.setString(5, tank.getTankclassno());
			psmt.setString(6, customer.getCustomerno());
			psmt.setString(7, ordermaster.getFlightclass().getPlane().getPlaneno());
			psmt.setString(8, null);//座位号，未选择就空分配
			int nReturn = psmt.executeUpdate();
			if (nReturn == 1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connfly.commitConn();
			connfly.closeConn();
		}
		return flag;
	}

	@Override
	public List<orderdetail> qrydetailBymaster(ordermaster ordermaster) {
		List<orderdetail> orderdetailsList=new ArrayList<orderdetail>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		String sSql="SELECT *"
				+ "from ORDERDETAIL a,CUSTOMER b,tank c,seat d"
				+ "where ORDERNO=?"
				+ "and a.CUSTOMERNO=b.CUSTOMERNO and a.TANKCLASSNO=c.TANKCLASSNO"
				+ "and a.SEATNO=d.SEATNO and a.PLANENO=d.PLANENO;";
		try {
			psmt=connfly.getConn().prepareStatement(sSql);
			psmt.setString(1, ordermaster.getOrderno());
			rs  = psmt.executeQuery();
			//接受返回的订单明细内容
			while (rs.next()) {
				orderdetail orderdetailOne=new orderdetail();
				
				//准备外码：舱等
				tank tankone=new tank();
				//注入舱等属性
				tankone.setTankclassno(rs.getString(13));
				tankone.setTankclassname(rs.getString(14));
				tankone.setTankprice(rs.getInt(15));
				
				//准备外码：乘客
				customer customerone=new customer();
				//注入乘客属性
				customerone.setCustomerno(rs.getString(9));
				customerone.setCustomername(rs.getString(10));
				customerone.setIdcardno(rs.getString(11));
				customerone.setMobilephoneno(rs.getString(12));
				customerone.setMobilephoneno(sSql);
				
				//准备外码：座位
				seat seatone=new seat();
					//注入外码：飞机，直接由该主订单找调度单种的外码的获取
				seatone.setPlane(ordermaster.getFlightclass().getPlane());
				
				seatone.setSeatno(rs.getString(17));
				seatone.setCono(rs.getInt(18));
				seatone.setRowno(rs.getInt(19));
				seatone.setSellstatus(rs.getString(20));
					//注入外码：舱等，由刚才注入明细单中的代码获取
				seatone.setTank(tankone);
					
				//准备完毕，获取完整的对象订单明细
				orderdetailOne.setOrder(ordermaster);
				orderdetailOne.setDetailsno(rs.getString(2));
				orderdetailOne.setTicketprice(rs.getInt(3));
				orderdetailOne.setTicketstatus(rs.getString(4));
				orderdetailOne.setTank(tankone);
				orderdetailOne.setCustomer(customerone);
				orderdetailOne.setSeat(seatone);
				
				orderdetailsList.add(orderdetailOne);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connfly.commitConn();
			connfly.closeConn();
		}
		
		return orderdetailsList;
	}

	@Override
	public boolean delOrderdetail(orderdetail orderdetail) {
		boolean flag = false;
		PreparedStatement psmt = null;
		String sSql="delete "
				+ "from ORDERDETAIL"
				+ "where ORDERNO=? and DETAILSNO=?";
		try {
			psmt=connfly.getConn().prepareStatement(sSql);
			psmt.setString(1, orderdetail.getOrder().getOrderno());
			psmt.setString(2, orderdetail.getDetailsno());
			int nReturn = psmt.executeUpdate();
			if (nReturn == 1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connfly.commitConn();
			connfly.closeConn();
		}
		return flag;
		
	}

	@Override
	public boolean delwholeOrder(ordermaster ordermaster) {
		return false;
		
	}

	@Override
	public List<orderdetail> qrydetailByCustomer(customer customer) {
		List<orderdetail> orderdetailsList=new ArrayList<orderdetail>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		String sSql="select *"
				+ "from ORDERDETAIL a,ORDERMASTER b,FLIGHTCLASS c,FLIGHT d,TANK e,PLANE f,seat g"
				+ "where a.CUSTOMERNO=? and a.ORDERNO=b.ORDERNO"
				+ "and b.FLIGHTCLASSNO=c.FLIGHTCLASSNO and b.FLIGHTNO=c.FLIGHTNO"
				+ "and c.FLIGHTNO=d.FLIGHTNO and c.PLANENO=f.PLANENO"
				+ "and a.TANKCLASSNO=e.TANKCLASSNO and a.SEATNO=g.SEATNO"
				+ "and a.PLANENO=g.PLANENO";
		
		try {
			psmt=connfly.getConn().prepareStatement(sSql);
			psmt.setString(1, customer.getCustomerno());
			rs  = psmt.executeQuery();
			
			while (rs.next()) {
				orderdetail oeOrderdetailOne=new orderdetail();
				
				//准备外码1：主订单
				ordermaster ordermasterone=new ordermaster();
				ordermasterone.setOrderno(rs.getString(1));
				ordermasterone.setOrdertime(null);//有些属性不关心，不设置，或者置空	
					//准备外码1.1：用户
				ordermasterone.setUser(null);//由于实际上不关心这个信息，故直接设null，下同此
					
					//准备外码1.2 ：航班班次
				flightclass flightclassOne=new flightclass();
				
						//准备外码1.2.1：航班
				flight flightOne=new flight();
				flightOne.setFlightno(rs.getString(24));
				flightOne.setFlightname(rs.getString(25));
				flightOne.setFlytime(rs.getDate(26));
				flightOne.setFlyplace(rs.getString(28));
				flightOne.setDistance(rs.getString(29));
				/**其他属性不需要，不设置**/
				
						//准备外码1.2.2：机组  置空
				
						//准备外码1.2.3：飞机
				plane planeone=new plane();
							//准备外码1.2.3.1：机型 置空
				planeone.setPlaneno(rs.getString(34));
				planeone.setSeatnum(rs.getInt(35));
				/**其他属性不需要，不设置,后续同**/
				
				
				//准备外码2：舱等
				tank tankone=new tank();
				tankone.setTankclassname(rs.getString(32));
				//准备外码3：座位
				seat seatone=new seat();
				seatone.setCono(rs.getInt(39));
				seatone.setRowno(rs.getInt(40));
					//准备外码3.1：舱等，用外码2
				seatone.setTank(tankone);
					//准备外码3.2：飞机，用外码1.2.3
				seatone.setPlane(planeone);
				
				//填补订单明细
				oeOrderdetailOne.setOrder(ordermasterone);
				oeOrderdetailOne.setDetailsno(rs.getString(2));
				oeOrderdetailOne.setTicketprice(rs.getInt(3));
				oeOrderdetailOne.setTicketstatus(rs.getString(4));
				oeOrderdetailOne.setTank(tankone);
				oeOrderdetailOne.setCustomer(customer);
				oeOrderdetailOne.setSeat(seatone);
				
				orderdetailsList.add(oeOrderdetailOne);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connfly.commitConn();
			connfly.closeConn();
		}
		return orderdetailsList;
	}

	@Override
	public List<seat> findOkseat(orderdetail orderdetail) {
		List<seat> seatsList=new ArrayList<seat>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		String sSql="select a.*,e.*,f.*"
				+ "from SEAT a,ORDERDETAIL b,ORDERMASTER c,FLIGHTCLASS d,PLANE e,TANK f"
				+ "where a.SEATNO=b.SEATNO"
				+ "and b.ORDERNO=c.ORDERNO and c.FLIGHTCLASSNO=d.FLIGHTCLASSNO"
				+ "and d.PLANENO=e.PLANENO and e.PLANENO=a.SEATNO"
				+ "and b.TANKCLASSNO=f.TANKCLASSNO"
				+ "and b.DETAILSNO=? and b.ORDERNO=?";
		try {
			psmt=connfly.getConn().prepareStatement(sSql);
			psmt.setString(1, orderdetail.getDetailsno());
			psmt.setString(2, orderdetail.getOrder().getOrderno());
			rs  = psmt.executeQuery();
			
			while (rs.next()) {
				seat seatone=new seat();
				
				//准备外码1：飞机
				plane planeone=new plane();
				planeone.setPlaneno(rs.getString(7));
				planeone.setSeatnum(rs.getInt(8));
				
				
				//准备外码2：舱等
				tank tankone=new tank();
				tankone.setTankclassno(rs.getString(10));
				tankone.setTankclassname(rs.getString(11));
				tankone.setTankprice(rs.getInt(12));
				
				//填充对象
				seatone.setPlane(planeone);
				seatone.setSeatno(rs.getString(2));
				seatone.setCono(rs.getInt(3));
				seatone.setRowno(rs.getInt(4));
				seatone.setSellstatus(sSql);
				seatone.setTank(tankone);
				seatsList.add(seatone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connfly.commitConn();
			connfly.closeConn();
		}
		return seatsList;
	}

	@Override
	public boolean selectSeat(seat seat, orderdetail orderdetail) {
		boolean flag = false;
		PreparedStatement psmt = null;
		String sSql ="UPDATE ORDERDETAIL"
				+ "set SEATNO=?"
				+ "where DETAILSNO=? and ORDERNO=?";
		try {
			psmt=connfly.getConn().prepareStatement(sSql);
			psmt.setString(1, seat.getSeatno());
			psmt.setString(2, orderdetail.getDetailsno());
			psmt.setString(3, orderdetail.getOrder().getOrderno());
			int nReturn = psmt.executeUpdate();
			if (nReturn == 1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connfly.commitConn();
			connfly.closeConn();
		}
		return flag;
		
	}
	
	@Override
	public boolean delSeat(orderdetail orderdetail) {
		boolean flag = false;
		PreparedStatement psmt = null;
		/*这里其实少做了一步：再讲座位外码断开之前，应当先将这个将要断开的
		 的座位的出售状态设置为0，应当要利用一个存储过程，但是这个我不会，暂时搁置！！！！*/
		String sSql="UPDATE ORDERDETAIL set SEATNO=NULL"
				+ "where ORDERNO=? and DETAILSNO=?";
		try {
			psmt=connfly.getConn().prepareStatement(sSql);
			psmt.setString(1, orderdetail.getOrder().getOrderno());
			psmt.setString(2, orderdetail.getDetailsno());
			int nReturn = psmt.executeUpdate();
			if (nReturn == 1) flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connfly.commitConn();
			connfly.closeConn();
		}
		
		return flag;
		
		
		
	}

}
