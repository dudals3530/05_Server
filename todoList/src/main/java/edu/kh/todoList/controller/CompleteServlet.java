package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/complete")
public class CompleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//전달받은 파라미터 얻어오기
			
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			TodoListService service = new TodoListServiceImpl();
			
			//할 일 여부를 변경하는 서비스 호출 후 결과 반환받기
			int result = service.todoComplete(todoNo);
			
			//result 값이 0보다 크다 == 변경성공
			//원래보고 있떤 상세페이지로 redirect
			//- > message "완료여부가 변경되었습니다!" alert
			HttpSession session = req.getSession();
			//변경 실패시
			// -> 메인페이지로 redirect
			// -> message "todo가 존재하지 않습니다" alert
			if(result > 0) {
				
				session.setAttribute("message", "완료 여부가 변경되었습니다!");
				resp.sendRedirect("/todo/detail?todoNo="+todoNo);
				return;
			}
			
			
			session.setAttribute("message", "todo가 존재하지않습니다" );
			resp.sendRedirect("/");
				
				
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
