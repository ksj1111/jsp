package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//자바소스 : http 통신방법을 활용해서 request(요청정보), response(응답정보) 생성처리.
//HttpServlet 클래스를 상속받아서 사용해야 함.
//서블릿의 실행: 개발자 x, Tomcat 컨테이너가 제어함.(IOC(Inverstion of Control): 제어의 역전)
//순서: 객체(생성자) -> init -> service -> destroy

public class FirstServlet extends HttpServlet {
	
	public FirstServlet() {
		//생성자 호출은 Servlet이 호출될때 한번만 실행됨.
		System.out.println("생성자 호출 성공 FirstServlet");
	}
	
	//init 메소드 호출 init 은 최초의 한번만 호출됨.
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init호출. FirstServlet");
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service호출. FirstServlet");
		if(req.getMethod().equals("GET")) {
			doGet(req, resp);
			
		}else if(req.getMethod().equals("POST")) {
			doPost(req, resp);
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy호출. FirstServlet");
	}

	
	//클라이언트 -> 서버요청 시 : get or post 방식이 있음.
	//주소창에 주소치ㅣ는것이 get 방식 또는 link 방식임.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get:주소창: url, a href="", <from method="get">
		//위 방식들이 get 요청하는 방식임.
		//특징: url 사용자가 입력값 노출. 용량제한.
		//응답정보 -> 클라이언트측.
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h3>Get방식요청</h3>");
		String id = req.getParameter("id"); // first? id=guest&pw=1234
		String pw = req.getParameter("pw");
		String test = req.getParameter("test");
		
		out.print("<p>입력id: " + id + ", 비번: " + pw+test + "</p>" );
		out.close();//리소스를 반환하겠습니다 의미
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h3>Get방식요청</h3>");
		String id = req.getParameter("id"); // first? id=guest&pw=1234
		String pw = req.getParameter("pw");
		
		out.print("<p>입력id: " + id + ", 비번: " + pw + "</p>");
		out.close();//리소스를 반환하겠습니다 의미
	
	}
}
