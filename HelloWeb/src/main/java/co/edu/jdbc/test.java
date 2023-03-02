package co.edu.jdbc;

import java.util.Map;

import co.edu.test.jdbcServlet;

public class test {

	public static void main(String[] args) {
		
		jdbcServlet js = new jdbcServlet();
		EmpDAO emp = new EmpDAO();
		Map<String, Object> list = emp.getEmpInfo(101);
		
		System.out.println(list.get("firstName"));
	}

}
