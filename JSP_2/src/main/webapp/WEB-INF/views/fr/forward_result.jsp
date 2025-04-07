<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>request scope 객체를 이용해서 전달받은값</h3>

    <ul>
		<li>forward 입력 1: ${param.forwardInput1}</li>
		<li>forward 입력 2: ${param.forwardInput2}</li>
		<li>forward 입력 3: ${str}</li>
		<li>str2 입력 : ${str2}</li>
		<li>sessionNum : ${sessionScope.sessionNum}</li>
        
    </ul>

</body>
</html>