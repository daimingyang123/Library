<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>利用者蔵書一覧</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/admin.css" type="text/css"></link>
    <link rel="stylesheet" type="text/css" href="css/header1.css"></link>
</head>
  
  <body>
     <div class="header" id="table">
  <table width="100%" border="0">
    <tr>
      <th width="25%" scope="col"><a href="header.jsp" class="pic"><img src="img/5.png" width="150" height="47" /></a></th>
      <th width="70%"  scope="col">&nbsp;</th>
      <th width="11%"  scope="col"><img src="img/user.jpg" width="60" height="49" /></th>
   </tr>
  </table>
</div>

<p/><s:iterator id="book" value="books" status="status">
<table width="100%" border="0">
<tr>

			<th scope="col" width="20%" align="left" >bookNo</th>
			<th scope="col" width="10%" align="left" >state</th>
			<th scope="col" width="30%" align="left" >title</th>
		    <th scope="col" width="40%" align="left" >plot</th>
		    
	    
</tr>
<tr class="<s:if test="#status.even">row-even</s:if><s:else>row-odd</s:else>">

			<th scope="col" width="20%" align="left" >${book.bookNo}</th>
			<th scope="col" width="10%" align="left" >${book.state}</th>
			<th scope="col" width="30%" align="left" >${book.title}</th>
		    <th scope="col" width="40%" align="left" >${book.plot}</th>
		    
	    
</tr>
</table>			
</s:iterator> 

</body>
</html>
