<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    用户列表<br/>
    <hr/>
	<c:forEach var="user" items="${pn.pageDate}">
		${user.id }&nbsp;${user.loginname}&nbsp;${user.loginpass }&nbsp;${user.uname }<br/>
	</c:forEach>
	<hr/>
	<a href="user/list.action?currentPage=1">首页</a>
	<c:if test="${pn.currentPage > 1}">
	<a href="user/list.action?currentPage=${pn.currentPage-1}">上一页</a>
	</c:if>
	<c:if test="${pn.currentPage < pn.totalPage}">
	<a href="user/list.action?currentPage=${pn.currentPage+1}">下一页</a>
	</c:if>
	<a href="user/list.action?currentPage=${pn.totalPage}">尾页</a>
  </body>
</html>
