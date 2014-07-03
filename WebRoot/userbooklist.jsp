<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<link rel="stylesheet" type="text/css" href="css/header1.css"></link>
    <link rel="stylesheet" type="text/css" href="css/userbooklist.css"></link>
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
<div class="search">
<div class="search2">
 <form class="contact_form" action="" method="post"  name="contact_form">
		<ul>
			<li>
				<label for="name"><img src="img/search2.jpg" style="height: 40px; width: 50px;  margin-top:20px; "></img></label>
				<input type="text" name="title" placeholder="書籍名入力し" style="height: 40px; width:350 px;  "/>
		        <button class="submit" type="submit" onclick="contact_form.action='findBook';contact_form.submit();">検索</button>
		        <button class="submit" type="submit" onclick="contact_form.action='orderBook';contact_form.submit();">予約</button>
		        <dt>
		        ${orderbook}
		        </dt>
		        <!--  <a href="orderBook.action"><button>order</button></a> -->
		    </li>
		</ul>
	</form>
	</div>
<table width="80%"  align="center" >
<tr>

			<th scope="col" width="20%" align="left" >書籍No</th>
			<th scope="col" width="10%" align="left" >状態</th>
			<th scope="col" width="30%" align="left" >書籍名</th>
		    <th scope="col" width="30%" align="left" >プロット</th> 
		   
	    
</tr>
</table>
<s:iterator id="book" value="books" status="status">
<table width="80%" align="center" >
<tr class="<s:if test="#status.even">row-even</s:if><s:else>row-odd</s:else>">

			<th scope="col" width="20%" align="left" >${book.bookNo}</th>
			<th scope="col" width="10%" align="left" >
			<c:choose>
       		<c:when test="${(book.state==null)}">
            已借出
       		</c:when>
		    <c:when test="${(book.state==1)}">
            在架可借
       		</c:when>
		    <c:otherwise>
		    已预约
		    </c:otherwise>
			</c:choose>

			</th>

			<th scope="col" width="30%" align="left" >${book.title}</th>
		    <th scope="col" width="30%" align="left" >${book.plot}</th>
		 
	    
</tr>
</table>			
</s:iterator> 
<div class="fanye">
<form  name="AddStudentForm"  action="getUsers.action" method="post" align="center" >
   ${pageIndex}ページ目&nbsp;&nbsp;
  総${pageCount}ページ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <logic:greaterThan name="pageIndex" scope="request" value="1">
      <a href="user.action?pageIndex=${pageIndex - 1}">前のページ</a>
  </logic:greaterThan>
  
  <logic:lessThan name="pageIndex" scope="request" value="${requestScope.pageCount}">
       <a href="user.action?pageIndex=${requestScope.pageIndex + 1}">次のページ</a>
  </logic:lessThan>
  &nbsp;&nbsp;ジャンプ<input size="4" type="text" name="pageIndex" id="pageIndex"/><input type="submit" value="go" />
</form>
<dt>${userbook}</dt>
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
    <td><a href="usersaying.jsp" >利用者の意見</a></td>
    <td><a href="#" >使用説明書</a></td>
    <td><a href="" >私達について</a></td>
 	</tr>
  	<tr align="center">
    <td><a href="databasesecurity.jsp" >データセキュリティ</a></td>
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
<script type="text/javascript">
	</script> 
</html>
