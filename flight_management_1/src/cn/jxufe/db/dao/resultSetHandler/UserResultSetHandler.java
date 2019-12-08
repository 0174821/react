package cn.jxufe.db.dao.resultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import cn.jxufe.db.domain.user;


public class UserResultSetHandler implements ResultSetHandler<List<user>>{
	@Override
	public List<user> handle(ResultSet rs) throws SQLException {
		List<user> userList=new ArrayList<user>();
		while(rs.next()){
			user user =new user();
			user.setUsername(rs.getString("USERNAME"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setUserno(rs.getString("USERNO"));
			user.setRegistercardno(rs.getString("REGISTERCARDNO"));
			user.setRegisterphoneno(rs.getString("REGISTERPHONENO"));
			userList.add(user);
		}
		return userList;
	}
}
