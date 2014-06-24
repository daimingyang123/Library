<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<title>${user.title}-${sessionScope.user}</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script src="javascript/prototype.js" type="text/javascript">
	
</script>

</head> 
<body>
<body onload="init();">
<table width="130">
	<tr>
		<td><a href="addblog_page.action">录入日志</a></td>
		<td><a href="userTitle.action?name=${sessionScope.user}">设置标题</a></td>

	</tr>
</table>
<hr>
<div style="width: 800px; text-align: right"><label
	style="font-size: 25px; color: red">${user.title}</label><br>
<label style="font-size: 16px; color: blue">${user.subTitle}</label><br>
</div>
<p /><s:iterator id="blog" value="blogs">
	<a href="viewBlog.action?id=${blog.id}"> ${blog.title}</a>
	<hr>
	<div style="width: 800px; font-size: 12px">
	&nbsp;&nbsp;&nbsp;&nbsp;摘要：${blog.blogAbstract}</div>
	<p />posted @ <fmt:formatDate value="${blog.postDate}"
		pattern="yyyy-MM-dd HH:mm:ss" />&nbsp;&nbsp;
	${blog.user.name}&nbsp;&nbsp; 阅读(${blog.viewCount}) | 评论
	(${blog.replyCount}) 

<c:if test="${(sessionScope.user != null) && (param.username == sessionScope.user || param.username == null)}">
| <a href="editBlog.action?id=${blog.id}">编辑</a> |
	<a href="javascript:deleteBlog(${blog.id})">删除</a>
</c:if>
	<hr>

	<p />
</s:iterator> 
<div style="width: 800px; text-align: center">

<c:if test="${model.pageCount > 1}">

   <c:forEach  begin="1" end="${model.pageCount}" varStatus="status"> 
        <c:set var="userparam" value="&username=${param.username}" />
        <a href="main.action?pageIndex=${status.count}${(param.username==null || param.username=='')?'':userparam }">${status.count}</a>   
    </c:forEach>    
</c:if>            
</div>
<script type="text/javascript">      
	function init() {
	GetBlogAction getBlogAction = new GetBlogAction();
		}
</script>
</body>
</html>
