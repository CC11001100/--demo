<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="UTF-8">
	<meta content="text/html;charset=utf-8" />
	<title>查询页面</title>
	<link rel="stylesheet" type="text/css" href="css/queryPage.jsp.css"></link>
</head>
<body>
	<div id="container">
		<!-- 显示标题 -->
		<div id="banner">雇员查询系统</div>
		<!-- 查询操作的主面板 -->
		<div id="panel">
			<form action="showQueryResultServlet" method="post" id="queryForm">
				<table>
					<!-- 姓名查询 -->
					<tr>
						<td><label for="empName">雇员姓名：</label></td>
						<td><input class="input" id="empName" name="empName" type="text" value="${param.empName }"></td>
					</tr>
					<!-- 职位查询 -->
					<tr>
						<td><label for="jobName">公司职位：</label></td>
						<td>
							<select class="input" name="jobName" id="jobName">
								<option value="-1">请选择职位</option>
								<c:forEach items="${requestScope.jobs }" var="e">
									<option value="${e.id }">${e.name }</option>
								</c:forEach>
								<option value="-2">所有职位</option>
							</select>
						</td>
					</tr>
					<tr><td colspan="2">&nbsp;<span class="tipMessage">${requestScope.errorMessage }</span></td></tr>
					<tr>
						<td colspan="2"><input class="button" type="submit" value="查询雇员明细"></td>
					</tr>
				</table>
			</form>
		</div>

	</div>
</body>
</html>
<script>

	(function(){
		document.getElementById("queryForm").onsubmit=function(){
			if(document.getElementById("jobName").value==-1){
				alert("请选择一个职位范围再使用姓名查询。");
				return false;
			}
			return true;
		};
	})();

</script>