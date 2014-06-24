<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ようこそ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  	<link rel="stylesheet" href="css/header1.css" type="text/css"></link></head>
  
  <body>
    <div class="header" id="table">
  <table width="100%" border="0">
    <tr>
      <th width="25%" scope="col"><a href="header.jsp" class="pic"><img src="img/5.png" width="150" height="47" /></a></th>
      <th width="50%"  scope="col">&nbsp;</th>
      <th width="10%"  scope="col"><a href="admin.jsp" class="text"><span>司書</span></a></th>
      <th width="10%"  scope="col"><a href="user.jsp" class="text"><span>利用者</span></a></th>
      <th width="11%"  scope="col"><img src="img/6.png" width="60" height="49" /></th>
   </tr>
  </table>
</div>
    <div class="mid"><br/><br/><br/><br/>
    <font class="font1">ようこそ <font class="font2">図書管理</font>システム</font><br/>
    <div class="mid_1"> <font class="font3">新刊</font></div>
    </div>
    <div class="div4">
    <div class="div4_1"><img src="img/l1.JPG"><input type="button" value="詳細を取得" name="getinf"></img></div>
    <div class="div4_2"><img src="img/l2.JPG"><input type="button" value="詳細を取得" name="getinf"></img></div>
    <div class="div4_3"><img src="img/l3.JPG"><input type="button" value="詳細を取得" name="getinf"></img></div>
    <div class="div4_4"><img src="img/l4.JPG"><input type="button" value="詳細を取得" name="getinf"></img></div>
    <div class="div4_5"><img src="img/l5.JPG"><input type="button" value="詳細を取得" name="getinf"></img></div>
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
    <td><a href="#" >利用者の意見</a></td>
    <td><a href="#" >使用説明書</a></td>
    <td><a href="#" >私達について</a></td>
 	</tr>
  	<tr align="center">
    <td><a href="#" >データセキュリティ</a></td>
    <td><a href="#" >ほかウェブサイト</a></td>
    <td><a href="#" >ヘルプビデオ</a></td>
    <td><a href="#" >お問い合わせ</a></td>
  	</tr>
  	<tr align="center">
    <td><a href="#" >支払いオプション</a></td>
    <td><a href="#" >マスコミの報道</a></td>
    <td><a href="#" >マイクロブロギング</a></td>
    <td><a href="#" >プライバシー</a></td>
  	</tr>
  	<tr align="center">
    <td><a href="#" >モバイル版</a></td>
    <td>&nbsp;</td>
    <td><a href="#" >フィードバック</a></td>
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

