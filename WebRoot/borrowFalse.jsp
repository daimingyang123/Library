<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>図書なし</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/borrowFalse.css" type="text/css"></link></head>
  
  <body>
  <div class="f1">
  <div class="f1_1"><img src="img/lf.jpg"></img></div>
  <div class="f1_2"><font> 図書なし。。。<a href="loginsuccess.jsp">他の本を閲覧してください</a></font></div>
  </div>
  </body>
</html>
