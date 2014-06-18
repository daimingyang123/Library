<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎界面</title>
    
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
      <th width="25%" scope="col"><a href="#" class="pic"><img src="img/5.png" width="150" height="47" /></a></th>
      <th width="6%"  scope="col">&nbsp;</th>
      <th width="13%"  scope="col"><a href="header.jsp" class="text"><span>Homepage</span></a></th>
      <th width="13%"  scope="col"><a href="borrowBook.jsp" class="text"><span>Borrow</span></a></th>
      <th width="13%"  scope="col"><a href="backBook.jsp" class="text"><span>Back</span></a></th>
      <th width="10%"  scope="col">&nbsp;</th>
      <th width="8%"  scope="col"><a href="admin.jsp" class="text"><span>Admin</span></a></th>
      <th width="6%"  scope="col"><a href="user.jsp" class="text"><span>User</span></a></th>
      <th width="11%"  scope="col"><img src="img/6.png" width="60" height="49" /></th>
   </tr>
  </table>
</div>
    <div class="mid"><br/><br/><br/><br/>
    <font class="font1">Welcome to <font class="font2">library</font> manage system</font><br/>
    <div class="mid_1"> <font class="font3">New book</font></div>
    </div>
   Error
    <div class="div5">
	<table width="100%" cellpadding="5" border="50px" bordercolor="#ECF0F5">
 	<tr align="center">
    <th scope="col">产品</th>
    <th scope="col">媒体</th>
    <th scope="col">支持</th>
    <th scope="col">更多</th>
  	</tr>
  	<tr align="center">
    <td><a href="#" >功能特性</a></td>
    <td><a href="#" >用户怎么说</a></td>
    <td><a href="#" >用户指南</a></td>
    <td><a href="#" >关于我们</a></td>
 	</tr>
  	<tr align="center">
    <td><a href="#" >数据安全</a></td>
    <td><a href="#" >他们也在用</a></td>
    <td><a href="#" >帮助视频</a></td>
    <td><a href="#" >联系我们</a></td>
  	</tr>
  	<tr align="center">
    <td><a href="#" >付费方案</a></td>
    <td><a href="#" >媒体报道</a></td>
    <td><a href="#" >官方微博</a></td>
    <td><a href="#" >隐私声明</a></td>
  	</tr>
  	<tr align="center">
    <td><a href="#" >移动版本</a></td>
    <td>&nbsp;</td>
    <td><a href="#" >在线反馈</a></td>
    <td><a href="#" >服务条款</a></td>
  	</tr>
 	<tr align="center">
    <td><a href="#" >公益计划</a></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  	</tr>
	</table>	
    </div>
  </body>
</html>
