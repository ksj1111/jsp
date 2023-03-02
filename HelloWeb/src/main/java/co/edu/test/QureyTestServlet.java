package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/queryTest")
//public class QureyTestServlet extends HttpServlet{
//
//	@Override
// 	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	//사용자가 값을 여러개를 전송.
//	//각 값을 System.out.print("콘솔에 출력");
//		
//		resp.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = resp.getWriter();//응답
//		
//		//사용자의 입력값: parameter 값이 넘어옴.
//		//?id=user&pw=1234 (Query String: 질의 문자열)
//		String id = req.getParameter("id");
//		String pw = req.getParameter("pw");
//		
//		out.print(html);
// 	}
//}
