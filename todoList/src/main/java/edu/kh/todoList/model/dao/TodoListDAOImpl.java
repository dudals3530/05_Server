package edu.kh.todoList.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import edu.kh.todoList.model.dto.Todo;

public class TodoListDAOImpl implements TodoListDAO{

	// JDBC 객체 참조 변수 +  Properties 참조변수선언
	
	// TodoListDAOImpl 생성자 /xml/sql.xml 경로 읽어오기
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	@Override
	public List<Todo> todoListFullview(Connection conn) {
		
		String sql = 
				
				
		
		return null;
	}

	@Override
	public int getCompleteCount(Connection conn) {
		
		return 0;
	}
	
	
}
