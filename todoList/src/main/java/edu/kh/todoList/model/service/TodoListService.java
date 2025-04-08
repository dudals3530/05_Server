package edu.kh.todoList.model.service;

import java.util.Map;

import edu.kh.todoList.model.dto.Todo;

// 유지보수성과 확장성, 테스트 용이성 때문. ..
// -> Controller 는 ServiceImpl을 직접쓰지 않고, Service 인터페이스를 의존하므로,
//    나중에 구현체가 바뀌어도 Controller는 영향을 받지않음.
// -> ServiceImpl 대신 NewServiceImpl 을 만들어서 새로운 로직을 적용하고 싶을때
//   쉽게 교체 가능

// 
/**할일 목록 반환 서비스
 * @return todoList + 완료된 개수 map 
 */
/**
 * 
 */
public interface TodoListService {

	Map<String, Object> todoListFullview() throws Exception;

	int todoAdd(String title, String detail) throws Exception;

	Todo todoDetail(int todoNo) throws Exception;

	
	// 완료여부 변경서비스
	int todoComplete(int todoNo) throws Exception;

	
		
	

	
	
	

}
