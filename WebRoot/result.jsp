<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.cc11001100.com/tld/sf" prefix="sf" %>

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
	<title>查询结果页面</title>
	<style>
	</style>
	<link rel="stylesheet" type="text/css" href="css/result.jsp.css"></link>
</head>
<body>
	<div id="container">
		<!-- 显示标题 -->
		<div id="banner">查询结果</div>
		<!-- 查询操作的主面板 -->
		<div id="panel">
			<table cellspacing="0px">
				<thead>
					<tr>
						<td>雇员编号</td>
						<td>雇员职位</td>
						<td>雇员姓名</td>
						<td>雇员性别</td>
						<td>雇员年龄</td>
						<td>所属部门</td>
						<td>雇员工龄</td>
					</tr>
				</thead>
				<tbody id="resultset">
					<%--检查是否查询到结果 --%>
					<c:if test="${empty requestScope.resultSet}">
						<tr>
							<td colspan="7">没有查询结果。</td>
						</tr>
					</c:if>
					
					<%--显示出来 --%>
					<c:forEach items="${requestScope.resultSet }" var="e">
					<tr>
						<td>${sf:formatInt(e.id,4) }</td>
						<td>${e.post.name }</td>
						<td>${e.name }</td>
						<td>${e.sex }</td>
						<td>${e.age }${"岁" }</td>
						<td>${e.depary }</td>
						<td>${e.empYear }${"年" }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
	</div>

<script src="js/queryPage.jsp.js"></script>	
</body>
</html>
