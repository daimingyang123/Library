<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>利用者登録失敗</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link rel="stylesheet" type="text/css" href="css/header1.css"></link>
    <link rel="stylesheet" type="text/css" href="css/loginfalse.css"></link>
</head>
  
  <body>
     <div class="f1">
  <div class="f1_1"><img src="img/false.jpg" style="height: 361px; width: 479px; "></img></div>
  <div class="f1_2"><font>ログインに失敗しました。。。<a href="user.jsp">再びログインしてください</a></font></div>
  </div>
  </body>
</html>
