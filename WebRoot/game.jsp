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
	<script src="script/jquery-1.3.2.min.js"></script>
	<script>
		$(function(){
			$('input[type=radio]').click(function(){
				var href = $('a').attr('href');
				if(/(choice=)[01](&idx)/.test(href)){
					href = href.replace(/(choice=)[01](&idx)/, RegExp.$1+this.value+RegExp.$2);
				}
				$.post('servlet/SaveResultServlet', 
					{idx:"${idx}", choice:this.value}
				);		
			});
		
		});
	</script>
  </head>
  
  <body>
  	result[${idx}]:${result[idx]} --- idx:${idx}<br/>
  	<br/>
    ${case.id}. ${case.cdesc }<br/>
    <c:if test="${idx >= 1}">
    <a href="servlet/GameServlet?choice=0&idx=${idx-1}">上一题</a>
 	</c:if>
 	
 	<c:if test="${result[idx] == 1}">
 		是<input type="radio" name="choice" value="1" checked/>
    	否<input type="radio" name="choice" value="0"/>
 	</c:if>
 	<c:if test="${result[idx] == 0}">
 		是<input type="radio" name="choice" value="1" />
    	否<input type="radio" name="choice" value="0" checked/>
 	</c:if>
 	
    <c:if test="${idx < case_size - 1}">
    <a href="servlet/GameServlet?choice=0&idx=${idx+1}">下一题</a>
 	</c:if>
 	<c:if test="${idx == case_size - 1}">
    <a href="servlet/GameServlet?choice=0&idx=${idx+1}">查看结果</a>
 	</c:if>
  </body>
</html>
