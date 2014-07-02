<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>書籍貸出し</title>
<script src="scripts/mootools.v1.11.js" type="text/javascript"></script>
<script src="scripts/sliding-tabs.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="scripts/style.css" media="screen"/>
<link rel="stylesheet" href="css/header1.css" type="text/css"></link>
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
<div class="wrapper">
  <div id="heading">
  <div style="margin-left: 24%;">
   <img src="images/leftAlt3.png" alt="" id="previous" />
    <ul id="buttons">
      <li>予約貸出し</li>
      <li>非予約貸出し</li>
    </ul>
    <img src="images/rightAlt3.png" alt="" id="next" /> 
    </div>
    </div>
  <div id="panes">
    <div id="content">
<div class="biaodan" style="border:1px solid rgba(173,173,173,0.1);background-color:#00BD9C;float:left;"> 
<img src="img/bo1.png" style="position:absolute;left:25%;top:17%;width:150px;height:255px;"></img>
	<form class="contact_form" action="borrowOrder" method="post" name="contact_form">
	<div class="div2_2">	
		<ul>
			<li>
				<label for="name">利用者名:</label>
				<input type="text" name="userName" class="username" placeholder="利用者名入力し" required pattern="^[\u4E00-\u9FFF]+$"/>
				<span class="form_hint">漢字</span>
			</li>
			<li>
				<label for="name">書籍名:</label>
				<input type="text" name="title" class="bookname" placeholder="書籍名入力し" required/>
			</li>
		<dt>
			${borrowbook}${borroworder}
         </dt>			
			<li style="margin:0 15%">
				<button class="submit" type="submit" >貸出し</button>
				<button class="submit1" type="reset">リセット</button>
			</li>
</ul>
</div>
	</form>
	
    
    </div>
    <div class="biaodan" style="border:1px solid rgba(173,173,173,0.1);background-color:#00BD9C;float:left;"> 
<img src="img/bo1.png" style="position:absolute;left:25%;top:17%;width:150px;height:255px;"></img>
	<form class="contact_form" action="borrow" method="post" name="contact_form">
	<div class="div2_2">
		<ul>
			<li>
				<label for="name">利用者名:</label>
				<input type="text" name="userName" placeholder="利用者名入力し" required pattern="^[\u4E00-\u9FFF]+$"/>
				<span class="form_hint">漢字</span>
			</li>
			<li>
				<label for="name">書籍名:</label>
				<input type="text" name="title" placeholder="書籍名入力し" required/>
				<span class="form_hint">名前</span>
			</li>
		 <dt>
			${borrowbook}${borroworder}
         </dt>
			<li style="margin:0 15%">
				<button class="submit" type="submit">貸出し</button>
				<button class="submit1" type="reset">リセット</button>
			</li>
</ul>
</div>
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
