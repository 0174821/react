package cn.jxufe.db.web;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jxufe.db.domain.plane;
import cn.jxufe.db.service.AdminService;
import cn.jxufe.db.service.impl.AdminServiceImpl;

public class AddAirPlaneServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("airPlaneManageMsg");
		AdminService aService=new AdminServiceImpl();
		plane airPlane=new plane();
		airPlane.setPlanetypeno(new String(request.getParameter("planetypeno").getBytes("ISO-8859-1"),"UTF-8"));
		airPlane.setSeatnum(Integer.parseInt(request.getParameter("seatnum")));
		try {
			aService.insertPlane(airPlane);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			response.sendRedirect(request.getContextPath()+"/airPlaneManage.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
