<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>一覧</title>
<script src="scripts/mootools.v1.11.js" type="text/javascript"></script>
<script src="scripts/sliding-tabs.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/header1.css" type="text/css"></link>
<link rel="stylesheet" href="css/booklist.css" type="text/css"></link>
</head>
<body>
<div class="header" id="table">
  <table width="100%" border="0">
   <tr>
      <th width="20%" scope="col"><a href="index.jsp" class="pic"><img src="img/5.png" width="150" height="47" /></a></th>
      <th width="12%"  scope="col"><a href="admin.action" class="text"><span>一覧</span></a></th>
      <th width="15%"  scope="col"><a href="borrowbook.jsp" class="text"><span>書籍貸出し</span></a></th>
      <th width="12%"  scope="col"><a href="returnbook.jsp" class="text"><span>書籍返却</span></a></th>
      <th width="15%"  scope="col"><a href="adduser.jsp" class="text"><span>利用者登録</span></a></th>
      <th width="12%"  scope="col"><a href="addbook.jsp" class="text"><span>書籍登録</span></a></th>
      <th width="5%"  scope="col">&nbsp;</th>
      <th width="11%"  scope="col"><span>${username}<span></th>
      <th><a href="logout.action"><button class="submit2" type="submit">終了</button></a></th>
   </tr>
  </table>
</div>
<div class="wrapper" >
  <div id="heading"><a href="getUsers.action"><img src="images/leftAlt3.png" alt="" id="previous" /></a>
    <ul id="buttons">
      <li><a href="getUsers.action">利用者一覧</a></li>
    <li><a href="admin.action">蔵書一覧</a></li>
    </ul>
   <a href="getUsers.action"><img src="images/rightAlt3.png" alt="" id="next" /></a>
     </div>
  <div id="panes">
    <div id="content">
        <div class="pane" id="about">
       <div class="search">
<table width="80%" align="center"  >
<tr>
            <th scope="col" width="10%" align="left" >&nbsp;</th>
			<th scope="col" width="10%" align="left" >利用者No</th>
			<th scope="col" width="20%" align="left" >利用者名</th>
			<th scope="col" width="30%" align="left" >Eメール</th>
	    
</tr>
</table>
<s:iterator id="user" value="users" status="status">
<table width="80%" align="center" >
<tr class="<s:if test="#status.even">row-even</s:if><s:else>row-odd</s:else>">
            <th scope="col" width="10%" align="left" >&nbsp;</th>
			<th scope="col" width="10%" align="left" >${user.userNo}</th>
			<th scope="col" width="20%" align="left" >${user.userName}</th>
			<th scope="col" width="30%" align="left" >${user.email}</th>   
</tr>
</table>			
</s:iterator> 
<form  name="AddStudentForm"  action="getUsers.action" method="post">
  第${pageIndex}页&nbsp;
  共${pageCount}页&nbsp;
  <a href="getUsers.action?pageIndex=1">首页</a>
  <logic:greaterThan name="pageIndex" scope="request" value="1">
      <a href="main.action?pageIndex=${pageIndex - 1}">上一页</a>
  </logic:greaterThan>
  
  <logic:lessThan name="pageIndex" scope="request" value="${requestScope.pageCount}">
       <a href="main.action?pageIndex=${requestScope.pageIndex + 1}">下一页</a>
  </logic:lessThan>
  
  <a href="getUsers.action?pageIndex=${requestScope.pageCount}">尾页</a>&nbsp;跳到<input size="4" type="text" name="pageIndex" id="pageIndex"/>页 <input type="submit" value="遷移" />
</form>
<dt>${adminuser}</dt>
  </div>
      </div>
    </div>
          <div class="pane" id="about">
      <div class="search">
<table width="80%"  align="center"  >
<tr>

			<th scope="col" width="20%" align="left" >書籍No</th>
			<th scope="col" width="10%" align="left" >状態</th>
			<th scope="col" width="30%" align="left" >書籍名</th>
		    <th scope="col" width="30%" align="left" >プロット</th>    
</tr>
</table>
<s:if test="book.state == 0">已借出</s:if>
<s:iterator id="book" value="books" status="status">
<table width="80%"  align="center" >
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
<form  name="AddStudentForm"  action="getUsers.action" method="post">
  第${pageIndex}页&nbsp;
  共${pageCount}页&nbsp;
  <a href="getUsers.action?pageIndex=1">首页</a>
  <logic:greaterThan name="pageIndex" scope="request" value="1">
      <a href="getUsers.action?pageIndex=${pageIndex - 1}">上一页</a>
  </logic:greaterThan>
  
  <logic:lessThan name="pageIndex" scope="request" value="${requestScope.pageCount}">
       <a href="getUsers.action?pageIndex=${requestScope.pageIndex + 1}">下一页</a>
  </logic:lessThan>
  
  <a href="getUsers.action?pageIndex=${requestScope.pageCount}">尾页</a>&nbsp;跳到<input size="4" type="text" name="pageIndex" id="pageIndex"/>页 <input type="submit" value="go" />
</form>
  </div>
      </div>
  </div>
</div>
<script type="text/javascript" charset="utf-8">
		window.addEvent('load', function () {
			myTabs = new SlidingTabs('buttons', 'panes');
			
			// this sets up the previous/next buttons, if you want them
			$('previous').addEvent('click', myTabs.previous.bind(myTabs));
			$('next').addEvent('click', myTabs.next.bind(myTabs));
			
			// this sets it up to work even if it's width isn't a set amount of pixels
			window.addEvent('resize', myTabs.recalcWidths.bind(myTabs));
		});
		
	</script>
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
