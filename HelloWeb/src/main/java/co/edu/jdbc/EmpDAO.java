package co.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class EmpDAO {

	Connection conn;
	ResultSet rs;
	PreparedStatement psmt;
	
	public void connect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try{Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,"hr","hr");
		
	}catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	
	}
	
	public Map<String, Object> getEmpInfo(int empId){
		connect();
		Map<String, Object> result = new HashMap<>();
		String sql = "select * from employees where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result.put("id", rs.getInt("employee_id"));
				result.put("firstName", rs.getString("first_name"));
				result.put("firstName", rs.getString("last_name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}







