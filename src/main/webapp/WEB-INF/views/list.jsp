<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>회원 리스트</title>
		<style>
		      table {
		        width: 100%;
		        border-top: 1px solid #444444;
		        border-collapse: collapse;
		      }
		      th, td {
		        border-bottom: 1px solid #444444;
		        padding: 10px;
		        text-align: center;
		      }
		      table,tr,td{
				  border:1px solid #000000;
				  border-collapse:collapse;
				}
				tr.colored:nth-child(even){
				  background-color:#F6F6F6;
				  color:#000000;
				}
				tr.colored:nth-child(odd){
				  background-color:#D5D5D5;
				  color:#000000;
				}
	    </style>
	</head>
	<body>
	<div align="center">
	<h2>회원 정보 리스트</h2>
	<hr width="500"/>
		<table border="1" width="80%" cellpadding="0" cellspacing="0">
		<%-- <colgroup>
			<col width="10%">
		</colgroup> --%>
			<tr>
				<td align="center" bgcolor='#6B66FF'>아이디</td>
				<td align="center" bgcolor='#6B66FF'>비밀번호</td>
				<td align="center" bgcolor='#6B66FF'>이름</td>
				<td align="center" bgcolor='#6B66FF'>전화번호</td>
				<td align="center" bgcolor='#6B66FF'>이메일</td>
				<td align="center" bgcolor='#6B66FF'>관리메뉴</td>
			</tr>
		<c:forEach var="mybatisMember" items="${mybatisMembers}">
			<tr class="colored">
				<td align="center">${mybatisMember.id}</td>
				<td align="center">${mybatisMember.pwd}</td>
				<td align="center">${mybatisMember.name}</td>
				<td align="center">${mybatisMember.tel}</td>
				<td align="center">${mybatisMember.email}</td>
				<td align="center">
				 <input type="button" 
					onClick="location.href='${pageContext.request.contextPath}/modifyMember/${mybatisMember.id}'" 
					value="회원수정"/>
				 <input type="button" 
				    onClick="location.href='${pageContext.request.contextPath}/delMember/${mybatisMember.id}'" 
				    value="회원삭제"/>			
				 <input type="button" 
				    onClick="location.href='${pageContext.request.contextPath}/inputForm'" 
				    value="회원가입"/>			
				</td>
			</tr>
		</c:forEach>
		</table>
	</div>
	
	
	</body>
</html>