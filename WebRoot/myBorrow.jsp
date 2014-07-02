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
      <th width="12%"  scope="col"><a href="user.action" class="text"><span>蔵書一覧</span></a></th>
      <th width="15%"  scope="col"><a href="myHome.jsp" class="text"><span>ホームページ</span></a></th>
      <th width="40%"  scope="col">&nbsp;</th>
      <th width="31%"  scope="col"><span>${username}</span></th>
      <th><a href="logout.action"><button class="submit2" type="submit">終了</button></a></th>
    </tr>
    </table>
	</div>
	<div class="all">
	<div class="left">
	<div class="left_1">
	<div class="left_11"><font class="font1l">個人情報</font></div>
	<img src="img/touxiang.jpg"></img>
	<div class="left_12"><font class="font2l">利用者名：${username}</font></div>
	<div class="left_12"><font class="font2l">利用者No：${userNo}</font></div>
	</div>
	
	<div class="left_2">
	<table width="100%">
	<tr><td><a href="myHome.jsp" ><img src="img/an1.png"></img><font class="font2l">読者情報セット</font></a></td></tr>
	<tr><td><a href="getborrows.action"><img src="img/an2.jpg"></img><font class="font2l">書籍貸出情報</font></a></td></tr>
	<tr><td><a href="myOrder.jsp" ><img src="img/an3 .jpg"></img><font class="font2l">予約情報</font></a></td></tr>
	</table>
	</div>
	</div>
	<div class="right">
	
	<!-- 可根据需要进行打印信息---美化界面 -->
	<table width="80%"  align="center"  >
<tr>

			<th scope="col" width="20%" align="left" >書籍No</th>
			<th scope="col" width="10%" align="left" >状態</th>
			<th scope="col" width="30%" align="left" >書籍名</th>
		    <th scope="col" width="30%" align="left" >プロット</th>    
</tr>
</table>
	
	<s:iterator id="booklist" value="bookMsgList" status="status">
    <table width="80%"  align="center"  >
    <tr class="<s:if test="#status.even">row-even</s:if><s:else>row-odd</s:else>">

			<th scope="col" width="20%" align="left" >${booklist.bookNo}</th>
			<th scope="col" width="10%" align="left" >${booklist.state}</th>
			<th scope="col" width="30%" align="left" >${booklist.title}</th>
		    <th scope="col" width="30%" align="left" >${booklist.plot}</th>
	    
   </tr>
   </table>			
   </s:iterator> 
	
	</div>
	</div>

</body>
</html>