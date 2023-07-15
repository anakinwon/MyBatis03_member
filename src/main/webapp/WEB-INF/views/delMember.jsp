<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 삭제</title>
<style type="text/css">
	.errMsg{font-size:9pt; color:red}
</style>
</head>
<body>
<div align="center">
<h2>회원정보삭제</h2>
<hr width="300" />
	<table border="1" cellpadding="2" cellspacing="0" width="300">
	<form:form commandName="mybatisMember" name="frm"
			   method = "post"
			   action="${pageContext.request.contextPath}/deleteOk">	
		<tr>
			<td align="center">
			<br/>
				아이디 : <form:input path="id" maxlength="20"/>
					   <%-- <form:errors path="id" cssClass = "errMsg"/> --%><p/>
				<span id="del" style="display:none">	   	   
					<input type="submit" value="삭제" />&nbsp;&nbsp;
				</span>
				<input type="reset" value="취소" />	   
			</td>
		</tr>
	</form:form>	
	</table>
</div>
<script type="text/javascript">
	if(document.frm.id.value !=""){
		document.getElementById("del").style.display="";
	}
</script>
</body>
</html>