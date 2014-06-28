<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>利用者の意見</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/header1.css"></link>
<link rel="stylesheet" type="text/css" href="css/usersaying.css"></link>
  </head>
  
  <body>
   
  <div class="header" id="table">
  <table width="100%" border="0">
   <tr>
      <th width="25%" scope="col"><a href="index.jsp" class="pic"><img src="img/5.png" width="150" height="47" /></a></th>
      <th width="81%"  scope="col">&nbsp;</th>
      
   </tr>
  </table>
</div>
<img src="img/us.jpg"  style="width: 1050px; "></img>
<div class="us">
<div class="us1">
<div class="us1_1"> <img src="img/dai.png"  ></img></div>
<div class="us1_2"> <font>"游戏开发需要高效的沟通和配合，在Library，一切任务都在拖拖拽拽中搞定，一切通知和提醒都及时送达， 没有学习成本，只有高效协作。简单方便，是我们选择Library最重要的理由。" </font>></div>

</div>
<div class="us1">
<div class="us1_1"> <img src="img/feng.png"  ></img></div>
<div class="us1_2"> <font>"我一直在寻找一款适合我们团队使用的协同工具，但因为各种原因最后都放弃了，直到用上Library， 才感觉找到了我的真爱，我愿意把它推荐给我们身边每一位有团队协同需求的朋友。" </font></div>

</div>
<div class="us1">
<div class="us1_1"> <img src="img/jia.jpg"  ></img></div>
<div class="us1_2"> <font>"及时快捷的通知，无处不在的关注，还有简单易用的话题，让团队沟通畅通无阻。 例如，一个小细节是，通过邮件直接回复即可参与评论和话题，也可以通过邮件创建任务，这简直太爽了。赶紧上线移动端吧，等不急了。" </font></div>

</div>
<div class="us1">
<div class="us1_1"> <img src="img/luo.png"  ></img></div>
<div class="us1_2"> <font>"作为一名ProjectManager，我用过各种项目管理工具，要么太复杂，要么体验太差。 Library足够简单，完全满足我对于项目管理的需求，而且体验也超级棒，最喜欢 Library中的拖拽操作，太酷了。" </font></div>

</div>
<div class="us1">
<div class="us1_1"> <img src="img/shao.jpg"  ></img></div>
<div class="us1_2"> <font>"关注和使用Library有一段时间了，可以感受到团队的用心和专注，每一天都可以感受到它的更新和变化。 用它做项目跟踪很方便，再也不需要让同事写日报了，直接在Library上自己更新进度。" </font></div>

</div>
<div class="us1">
<div class="us1_1"> <img src="img/sun.jpg"  ></img></div>
<div class="us1_2"> <font>"协作工具用过许多，Library是唯一一个坚持超过3个月仍然在用的。 极致的简单是让团队每一个人持续使用他的关键。开始用他时就觉得所有我需要的功能碰巧都在那里， 好像早就会用一样。还有一点很重要，“专业本土团队”！需求反馈快速，你的想法很可能成为下一版的新功能。" </font></div>

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
