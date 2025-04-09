<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${todo.todoTitle} 수정 페이지</title>
</head>
<body>

    <h1>${sessionScope.loginMember}</h1>

	<h4>할 일 수정</h4>
	
	<%-- /todo/update  - POST 방식 요청
		 			   ->UpdateServlet 클래스에 do Post() 오버라이딩
	 --%>
	<form action="/todo/update" method="post" id="updateForm">
		<div>
			제목 : <input type="text" name="title" value="${todo.todoTitle}">
		</div>
		<div>
			<textarea rows="3" cols="50" name="detail" placeholder="상세내용">${todo.todoDetail}</textarea>
			
		</div>
			
			<input type="hidden" name="todoNo" value="${param.todoNo}">
			<%--
				todoNo 도 수정 요청시 파라미터로 보내기
				왜? 
				어떤 todoNo를 가진 행을 수정하고자 하는 것인지
				SQL의 WHERE (조거식)에서 이용해야하기 때문.
				
				param. -> url에 있는 ? todoNo=1
				EL 표현식에서 ${param.key} - > ${param.todoNo} -> 1반환
			 --%>
			 
			 <%-- session 범위에 message가 있을경우  --%>
	<c:if test="${not empty sessionScope.message}">
		<script>											 
			//Js 영역
			alert("${message}");
			// JSP 해석순위
			// 1순위 : Java(EL/JSTL)
			// 2순위 : Front(HTML/css/js)
		</script>
		
		<%-- message를 한번만 출력하고 제거 --%>
		<c:remove var="message" scope="session"/>
	</c:if>
		
		<button>수정완료</button>
	</form>

	
</body>
</html>