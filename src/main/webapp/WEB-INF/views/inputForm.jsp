<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
<style>
	.msg{font-size:10pt; color:red;}
</style>

</head>
<body>
<div align="center">
	<h2>회원 가입 페이지</h2>
	<hr width="500" color="green"/>
	
	<table border="1" cellpadding="2" cellspacing="0" width="500">
		
	<form:form commandName="mybatisMember" method="post" action="insertOk">	
		<tr>
			<td>아이디</td>
			<td><form:input path="id" maxlength="20"/>
				<form:errors path="id" cssClass="msg"/>
			</td>		
		</tr>
		
		<tr>
			<td>이름</td>
			<td><form:input path="name" maxlength="50"/>
				<form:errors path="name" cssClass="msg"/> 
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><form:password path="pwd" maxlength="20"/>
				<form:errors path="pwd" cssClass="msg"/>
			</td>  
		</tr>
		<tr>
			<td>전화번호</td>
			<td><form:input path="tel" maxlength="13"/>
				<form:errors path="tel" cssClass="msg"/>
			</td> 
		</tr>
		<tr>
			<td>이메일</td>
			<td><form:input path="email" maxlength="50" />
				<form:errors path="email" cssClass="msg" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="취소"/>
			</td>
		</tr>
	</form:form>
	</table>
</div>
</body>
</html>