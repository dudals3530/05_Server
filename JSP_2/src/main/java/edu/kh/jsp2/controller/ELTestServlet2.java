package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/el/scope")
public class ELTestServlet2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청처리
		
		// 1.page scope -> JSP 에서만 확인가능(딱 1페이지)
		
		// 2. request scope 
		// - 요청받은 servlet 과 요청이 위임된 JSP에서 유지되는 객체
		
		//1 ) 객체에 값 (속성) 추가하는 방법
		//    범위객체.setAttribute("key","value");
		
		// 2) 객체에서 값 (속성) 얻어오는 방법
		//    Object 범위객체.getAttribute("key");
		// -> 반환형 Object - > 필요 시 다운캐스팅
		
		req.setAttribute("requestValue", "request scope 객체에 세팅한 값");
		//requestValue = request scope 객체에 세팅한 값
		
		System.out.println(req.getAttribute("requestValue"));
		
		// 3. session scope ex ) 로그인 세션만료 ? ?같은 
		// - 클라이언트가 서버에 첫 요청 시
		//   서버쪽에 생성되는 객체
		//- 클라이언트가 브라우저를 종료하거나
		//  지정된 세션 만료 시간이 지나면 사라짐.
		//-> 위 상황이 아니면 계속 유지된느 객체

		//1) session cope 객체 얻어오기
		HttpSession session = req.getSession();
		
		//2) Session scope 값 세팅해보기
		session.setAttribute("sessionValue","Session scope 객체에 세팅한 값" );
		
		
		
		
		// 4. application scope
		// - 서버 전체에 1개만 존재하는 객체
		// -> 모든 클라이언트가 공유
		// - 서버시작 시 생성, 서버 종료 시 소멸
		
		//1) application scope 객체 얻어오기
		ServletContext application =req.getServletContext(); // -> 이게 application scope 얻어오는방법 ㅇㅇ..
		
		//2 ) 값세팅
		application.setAttribute("applicationValue", "application scope 객체에 세팅한 값");
		
		// --------------------------------------------------------------------------------------------
		
		// 범위별 우선순위 확인!!
		// 좁은범위가 우선순위 높다!!
		// page > request > session > application
		
		
		// key값을 동일하게 하여 범위별 객체에 값 추가
		req.setAttribute("menu", "짬뽕(request)");
		session.setAttribute("menu", "짜장(session)");
		application.setAttribute("menu", "볶음밥(application)");
		
		
		
		// --------------------------------------------------------------------------------------------
		
		//응답처리
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/el/scope.jsp");
		
		dispatcher.forward(req, resp);
	
		
	}

}
