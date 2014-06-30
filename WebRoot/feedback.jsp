<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>フィードバック</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/feedback.css"></link>
    <link rel="stylesheet" type="text/css" href="css/header1.css"></link>

  </head>
  
  <body>
  <div class="header" id="table">
  <table width="100%" border="0">
   <tr>
      <th width="25%" scope="col"><a href="index.jsp" class="pic"><img src="img/5.png" width="150" height="47" /></a></th>
      <th width="80%"  scope="col">&nbsp;</th>
   </tr>
  </table>
</div>
<div class="page">
<i style="font-size:40">フィードバック</i>
</div>
<div class="page1">
<div style="font-size:40;color:red">
いつでもあなたの問題を解決する
</div>
<div class="feedback_form">
<form name="feedback_form">
<div>
  <select class="feedback">
  <option value="">何かお手伝いできることはございませんか？</option>                                
  <option value="0">使用中問題が発生した、専門家の助けを必要とします</option>                          
  <option value="1">バグを発見し、すぐにあなたを教えて</option>                  
  <option value="2">不足している、助言するようになった</option>                       
  <option value="3">製品は良いです、料金を知りたい</option>                 
  <option value="4">緊急事態、是非私を助けて</option>                                   
  <option value="5">ただ話をしたかった</option>                                    
  <option value="6">素晴らしい</option>
  </select>
</div>
<div class="form-control">
    <textarea rows=25 cols=115 name="feedback_desc" placeholder="我々は具体的に知っておく必要があるのことは何ですか？"></textarea>
</div>
<div class="sb">
<input type="button" onclick="submit()" value="フィードバックを送信" name="getuser"/>
</div>
</form>
</div>
</div>
</body>
</html>
