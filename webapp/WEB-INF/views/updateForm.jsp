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
	<h1>[Phonebook2]</h1>
	
	<h2>전화번호 수정 폼(form)</h2>
	
	<p>전화번호를 수정하려면<br>
	   아래에 항목을 수정하고 "수정" 버튼을 누르세요.
	</p>
	
	<form action="/phonebook3/phone/update" method="get">
   		이름(name) : <input type="text" name="name" value="${pinfo.name }"><br>
   		핸드폰(hp) : <input type="text" name="hp" value="${pinfo.hp }"><br>
   		회사(company) : <input type="text" name="company" value="${pinfo.company }"><br>
   		<!-- 코드(id) :  --><input type=hidden name="personId" value="${pinfo.personId }">  <br>
   <button type="submit">수정</button>
   </form>
   
	

</body>
</html>