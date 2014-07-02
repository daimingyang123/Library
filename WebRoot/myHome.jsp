<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>個人ページ</title>
    
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
	<tr><td><a href="myHome.jsp"style="color:blue;"><img src="img/an1.png"></img><font class="font2l">読者情報セット</font></a></td></tr>
	<tr><td><a href="myBorrow.jsp" ><img src="img/an2.jpg"></img><font class="font2l">書籍貸出情報</font></a></td></tr>
	<tr><td><a href="myOrder.jsp" ><img src="img/an3 .jpg"></img><font class="font2l">予約情報</font></a></td></tr>
	</table>
	</div>
	</div>
	<div class="right">
		<form class="contact_form" action="" method="post" name="contact_form">
		<ul>
			<li>
				<label for="name">利用者No:</label>
				<input type="text" name="name" placeholder="利用者No入力し" required pattern="^[0-9]*$"/>
				<span class="form_hint">数字のみ</span>
			</li>
			<li>
				<label for="name">利用者氏名:</label>
				<input type="text" name="name" placeholder="利用者氏名入力し" required pattern="^[\u4E00-\u9FFF]+$"/>
				<span class="form_hint">漢字</span>
			</li>
			<li>
				<label for="email">Eメール:</label>
				<input type="email" name="email" placeholder="メールアドレス入力し" required/>
				<span class="form_hint">アドレス</span>
			</li>
			
			<li>
				<button class="submit" type="submit">変更</button>
				<button class="submit1" type="reset">リセット</button>
			</li>
		</ul>
	</form>
	</div>
	</div>

</body>
</html>