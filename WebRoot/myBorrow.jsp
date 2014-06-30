<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>返却情報</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="css/header1.css"></link>
	<link rel="stylesheet" href="css/myHome.css" type="text/css"></link>
	</head>
  
	<body>
	<div class="header" id="table">
	<table width="100%" border="0">
    <tr>
      <th width="25%" scope="col"><a href="index.jsp" class="pic"><img src="img/5.png" width="150" height="47" /></a></th>
      <th width="12%"  scope="col"><a href="userbooklist.jsp" class="text"><span>蔵書一覧</span></a></th>
      <th width="15%"  scope="col"><a href="myHome.jsp" class="text"><span>ホームページ</span></a></th>
      <th width="70%"  scope="col">&nbsp;</th>
      <th width="11%"  scope="col">${userName}</th>
      <th><a href="logout.action"><button class="submit2" type="submit">終了</button></a></th>
    </tr>
    </table>
	</div>
	<div class="left">
	<div class="left_1">
	<div class="left_11"><font class="font1l">個人情報</font></div>
	<img src="img/touxiang.jpg"></img>
	${userName}
	</div>
	
	<div class="left_2">
	<table width="100%">
	<tr><td><a href="myHome.jsp" ><img src="img/an1.png"></img><font class="font2l">読者情報セット</font></a></td></tr>
	<tr><td><a href="getborrows.action" style="color:blue;"><img src="img/an2.jpg"></img><font class="font2l">返却情報</font></a></td></tr>
	<tr><td><a href="myOrder.jsp" ><img src="img/an3 .jpg"></img><font class="font2l">予約情報</font></a></td></tr>
	</table>
	</div>
	</div>
	<div class="right">
	
	<!-- 可根据需要进行打印信息---美化界面 -->
	
	<s:iterator id="booklist" value="bookMsgList" status="status">
    <table>
    <tr class="<s:if test="#status.even">row-even</s:if><s:else>row-odd</s:else>">

			<th scope="col" width="20%" align="left" >${booklist.bookNo}</th>
			<th scope="col" width="10%" align="left" >${booklist.state}</th>
			<th scope="col" width="30%" align="left" >${booklist.title}</th>
		    <th scope="col" width="30%" align="left" >${booklist.plot}</th>
	    
   </tr>
   </table>			
   </s:iterator> 
	
	</div>


</body>
</html>