package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Servlet 관련코드를 작성하기 위 해서는 HttpServlet 클래스를 상속받아야함.
//-> 상속받았따고 해서 바로 Servlet 등록이 되는것이아님.
//-> 1. web.xml 작성하기 2. @WebServlet() 어노테이션 사용


/*
 * 어노테이션 : 컴파일러가 읽는 주석
 * 
 * @WebServlet 어노테이션
 * -> 해당 클래스를 Servlet으로 등록하고
 *  () 안에 작성된 매핑할 주소와 연결하라고 지시하는 어노테이션
 *  
 *  -> 서버 실행시 자동으로 web.xml에 
 *  <servlet> <servlet-mapping>을 작성하는 효과
 * */

@WebServlet("/signUp")
public class ExampleController2 extends HttpServlet{
	
	//req.setCharacterEncoding("UTF-8");  -> 이거이제 생략가능 개꿀
	
	
	//post 요청 처리 메서드 오버라이딩
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		String inputName = req.getParameter("inputName");
		String intro = req.getParameter("intro");
		
		System.out.println(inputId+ inputName + inputPw + intro);
		
		//응답화면 만들기
		// -> Java에서 응답화면을 작성하기 번거롭고 힘들다 .. 
		// -> JSP가 대신 화면을 만들어달라! 위임해버려 젭ㄹ .. (Servlet이 JSP에게 요청/응답을 위임)
		
		// JSP가 대신 응답 화면을 만들어주기 위해서는 
		// Servlet이 어떤 요청을 받았는지 알아야한다! (req, resp) 
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/result.jsp");
																//webapp 폴더 기준 - > (이걸 루트라고생각하면됨)
		// -> webapp 폴더는 웹 어플리케이션의 루트 (root) 디렉토리로,
		// 	  브라우저를 통해 접근 가능한 정적 및 동적 리소스들이 위치하는 폴더
		// -> webapp 폴더가 컨텍스트 루트 (/)로 설정되기 때문에,
		//    해당 경로가 webapp 내부 경로로 해석되는 것 .
		
		// WEB-INF 폴더에 있는 파일들은 클라이언트가 직접적으로 접근할 수 없는 영역,
		// 서블릿을 통해서만 접근 가능
		
		dispatcher.forward(req, resp);
		// RequestDispatcher 객체를 사용하여 현재 요청 (req) 와 응답 (resp)를
		// 지정한 JSP 페이지 (result.jsp)로 전달하는 작업.
		// -> 즉 , 현재 서블릿 (ExampleContrller2)에서 처리하던 요청을 result.jsp 로 전달하고
		// 제어권을 그곳으로 넘김 (== 위임하다.)
				
		
		
	}
	
	
	
}


























