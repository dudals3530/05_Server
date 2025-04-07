package edu.kh.todoList.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static edu.kh.todoList.common.JDBCTemplate.*;
import edu.kh.todoList.model.dao.TodoListDAO;
import edu.kh.todoList.model.dao.TodoListDAOImpl;
import edu.kh.todoList.model.dto.Todo;

public class TodoListServiceImpl implements TodoListService{
	
	private TodoListDAO dao = new TodoListDAOImpl();
	
	@Override
	public Map<String, Object> todoListFullview() {
		
		//커넥션 생성
		Connection conn = getConnection();
		
		// dao 호출 및 반환 받기
		// 1) 할일 목록 얻어오기
		List<Todo> todoList = dao.todoListFullview(conn);
		
		// 2) 완료된 할일 개수 카운트
		int complteCount = dao.getCompleteCount(conn);
		
		// Map에 1,2 번으로 얻어온 데이터를 세팅하여 리턴
		
		
		return null;
	}

	
}
