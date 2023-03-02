package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.jdbc.EmpDAO;

@WebServlet("/getUserInfo")
public class jdbcServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		EmpDAO dao = new EmpDAO();
		
		Map<String, Object> result = dao.getEmpInfo(Integer.parseInt(req.getParameter("empId")));
		Set<String> set = result.keySet();
		for(String key : set) {
			System.out.println("key: " + "val: " + result.get(key));
		}
		//페이지 출력. 사번/이름(이름+성씨)/급여/부서
		PrintWriter out = resp.getWriter();
		
		//페이지 작성.
		
		out.print(result.get("id"));
		out.print(result.get("firstName"));
		out.print("<a> href='temp.html'>조회-등록으로 이동</a>");
		out.close();
	}
}
