package cn.jxufe.db.dao.resultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import cn.jxufe.db.domain.plane;

public class AirPlaneResultSetHandler implements ResultSetHandler<List<plane>>{
	@Override
	public List<plane> handle(ResultSet rs) throws SQLException {
		List<plane> airPlanes =new ArrayList<plane>();
		while (rs.next()) {
			plane airPlane=new plane();
			airPlane.setPlaneno(rs.getString("PLANENO"));
			airPlane.setSeatnum(rs.getInt("SEATNUM"));
			airPlane.setPlanetypeno(rs.getString("PLANETYPENO"));
			airPlanes.add(airPlane);
		}
		return airPlanes;
	}

}
