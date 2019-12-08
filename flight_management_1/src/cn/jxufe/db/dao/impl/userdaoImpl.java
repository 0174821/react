package cn.jxufe.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.jxufe.db.dao.userdao;
import cn.jxufe.db.dao.resultSetHandler.UserResultSetHandler;
import cn.jxufe.db.domain.user;
import cn.jxufe.db.util.DaoUtils;

public class userdaoImpl implements userdao
{
	private static final String CHECK_LOGIN_SQL="select * from USERS where USERNO=? and PASSWORD=?";
	public user login(String userno, String password) {
		user user=null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//QueryRunner runner =new QueryRunner(DaoUtils.getSource());
		try {
			//List<user> list=runner.query(CHECK_LOGIN_SQL,new UserResultSetHandler(), userno,password);
			conn = DaoUtils.getConn();
			String sql = CHECK_LOGIN_SQL;
			st = conn.prepareStatement(sql);
			st.setString(1, userno);
			st.setString(2, password);
			st.executeUpdate();
			//获取数据库自动生成的主键
			rs = st.getGeneratedKeys();
			System.out.print("1312312");
			if(rs!=null) { //user=(user)rs;
				user.setUsername(rs.getString("USERNAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setUserno(rs.getString("USERNO"));
				user.setRegistercardno(rs.getString("REGISTERCARDNO"));
				user.setRegisterphoneno(rs.getString("REGISTERPHONENO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void insertUser(user user) {
		// TODO Auto-generated method stub
		
	}

	public void reCharge(user user, float number) {
		// TODO Auto-generated method stub
		
	}

}
