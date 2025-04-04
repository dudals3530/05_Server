package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청에 대한 별도 처리 없이바로 JSP로 요청위임
		
		//1) 요쳥 위임할 JSP 경로 작성
		// -> webapp 폴더를 기준으로 작성
		
		
		String path = "/WEB-INF/views/signUp_result.jsp";
		
		
		//2) 요청을 위임시켜줄 객체 얻어오기 (요청 발송자)
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
	}

}
