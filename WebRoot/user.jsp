<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>司書登録</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/admin.css"></link>
    <link rel="stylesheet" type="text/css" href="css/header1.css"></link>
</head>
<body>
<div class="header" id="table">
  <table width="100%" border="0">
    <tr>
      <th width="25%" scope="col"><a href="index.jsp" class="pic"><img src="img/5.png" width="150" height="47" /></a></th>
      <th width="50%"  scope="col">&nbsp;</th>
      <th width="10%"  scope="col"><a href="admin.jsp" class="text"><span>司書</span></a></th>
      <th width="10%"  scope="col"><a href="user.jsp" class="text"><span>利用者</span></a></th>
      <th width="11%"  scope="col"><img src="img/6.png" width="60" height="49" /></th>
   </tr>
  </table>
</div>
  <div class="div2">
    <div class="div2_1">
    <img src="img/user.jpg"></img>
    </div>
    <div class="div2_2" >
    <form class="contact_form" action="login" method="post" name="contact_form">
		<ul>
			<li>
				<label for="name">利用者No:</label>
				<input type="text" name="userNo" placeholder="利用者No入力し" required pattern="^[0-9]*$"/>
				<span class="form_hint">数字のみ</span>
			</li>
			<li>
				<label for="name">利用者名:</label>
				<input type="text" name="userName" placeholder="利用者入力し" required pattern="^[\u4E00-\u9FFF]+$"/>
				<span class="form_hint">漢字</span>
			</li>
		<p>
			${error}
       </p>
			<li>
				<button class="submit" type="submit">ログイン</button>
				<button class="submit1" type="reset">リセット</button>
			</li>
		</ul>
	</form>
    </div>
	
    </div>
    <div class="div5">
	<table width="100%" cellpadding="5" border="50px" bordercolor="#ECF0F5">
 	<tr align="center">
    <th scope="col">製品</th>
    <th scope="col">メディア</th>
    <th scope="col">サポート</th>
    <th scope="col">もっと</th>
  	</tr>
  	<tr align="center">
    <td><a href="#" >機能</a></td>
    <td><a href="UserSaying.jsp" >利用者の意見</a></td>
    <td><a href="#" >使用説明書</a></td>
    <td><a href="#" >私達について</a></td>
 	</tr>
  	<tr align="center">
    <td><a href="DatabaseSecurity.jsp" >データセキュリティ</a></td>
    <td><a href="#" >ほかウェブサイト</a></td>
    <td><a href="#" >ヘルプビデオ</a></td>
    <td><a href="callus.jsp" >お問い合わせ</a></td>
  	</tr>
  	<tr align="center">
    <td><a href="#" >支払いオプション</a></td>
    <td><a href="#" >マスコミの報道</a></td>
    <td><a href="http://www.renren.com/394144430" >マイクロブロギング</a></td>
    <td><a href="#" >プライバシー</a></td>
  	</tr>
  	<tr align="center">
    <td><a href="#" >モバイル版</a></td>
    <td>&nbsp;</td>
    <td><a href="feedback.jsp" >フィードバック</a></td>
    <td><a href="#" >利用規約</a></td>
  	</tr>
 	<tr align="center">
    <td><a href="#" >慈善活動</a></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  	</tr>
	</table>
    </div>
  </body>
</html>

