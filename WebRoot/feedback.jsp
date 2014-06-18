<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>feedback</title>
    
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
      <th width="25%" scope="col"><a href="header.jsp" class="pic"><img src="img/5.png" width="150" height="47" /></a></th>
      <th width="12%"  scope="col"><a href="loginsuccess.jsp" class="text"><span>Booklist</span></a></th>
      <th width="12%"  scope="col"><a href="borrowBook.jsp" class="text"><span>Borrow</span></a></th>
      <th width="12%"  scope="col"><a href="backBook.jsp" class="text"><span>Back</span></a></th>
      <th width="12%"  scope="col"><a href="addbook.jsp" class="text"><span>AddBook</span></a></th>
      <th width="12%"  scope="col"><a href="adduser.jsp" class="text"><span>AddUser</span></a></th>
      <th width="4%"  scope="col">&nbsp;</th>
      <th width="11%"  scope="col"><img src="img/6.png" width="60" height="49" /></th>
   </tr>
  </table>
</div>
<div class="page">
<i style="font-size:40">在线反馈</i>
</div>
<div class="page1">
<div style="font-size:40;color:red">
我们准备好，随时为您解决问题
</div>
<div class="feedback_form">
<form name="feedback_form">
<div>
  <select class="feedback">
  <option value="">您需要什么样的帮助？</option>                                
  <option value="0">遇到使用问题，需要专业支持</option>                          
  <option value="1">发现一个Bug，赶快告诉你们</option>                  
  <option value="2">还有不足，我是来提建议的</option>                       
  <option value="3">产品靠谱，我想了解资费情况</option>                 
  <option value="4">紧急情况，快来帮帮我</option>
                                    
  <option value="5">乱七八糟的想法，就是想聊一下</option>
                                    
  <option value="6">你们太棒了，点个赞</option>
  </select>
</div>
<div class="form-control">
    <textarea rows=25 cols=115 name="feedback_desc" placeholder="具体需要我们知道的事情有什么?"></textarea>
</div>
<div class="sb">
<input type="button" onclick="submit()" value="提交反馈" name="getuser"/>
</div>
</form>
</div>
</div>
</body>
</html>
