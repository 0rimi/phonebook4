<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>[phonebook4]</h1>
	
	<h2>전화번호 리스트</h2>
	
	<p>입력한 정보 내역입니다.</p>
	
	<c:forEach items="${requestScope.pList }" var="vo">
		<table border="2">
			<tr>
				<td>이름(name)</td>
				<td>${vo.name }</td>  <!-- getter개념 -->
			</tr>
			<tr>
				<td>핸드폰(hp)</td>
				<td>${vo.hp }</td>
			</tr>
			<tr>
				<td>회사(company)</td>
				<td>${vo.company }</td>
			</tr>
			<tr>
				<td>
					<a href="/phonebook4/phone/updateForm?no=${vo.personId }">수정하기</a>
				</td>
				<td>
					<a href="/phonebook4/phone/delete?no=${vo.personId }">삭제하기</a>
				</td>
			</tr>
		</table>
		<br>
	</c:forEach>

	<a href="/phonebook4/phone/writeForm">추가하기</a>
	
</body>
</html>