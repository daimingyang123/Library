package com.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 

import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

public class LoginFilter extends HttpServlet implements Filter   {
	private static final long serialVersionUID = 1L; 

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");//这里设置如果没有登陆将要转发到的页面  
		  HttpServletRequest req = (HttpServletRequest) request;  
		  HttpServletResponse res = (HttpServletResponse) response;  
		  HttpSession session = req.getSession(true);
		  //获取当前URL
		  String url=req.getRequestURI();
		  
		  System.out.println("URL--"+url);
		  
		  System.out.println(((HttpServletRequest) request).getRequestURI()); 
		  
		  List<String> excludedPages =new ArrayList<String>();
		  excludedPages.add("/Library/index.jsp");
		  excludedPages.add("/Library/user.jsp");
		  excludedPages.add("/Library/admin.jsp");
		  excludedPages.add("/Library/callus.jsp");
		  excludedPages.add("/Library/DatabaseSecurity.jsp");
		  excludedPages.add("/Library/UserSaying.jsp");
		  if (excludedPages.contains(url)){
			  System.out.println("登录界面！");  
			  chain.doFilter(request,response);
			  return;
		  }
		  // 从session里取的用户名信息  
		  String username = (String) session.getAttribute("username");
		// 判断如果没有取到用户信息,就跳转到登陆页面  
		  if (username == null || "".equals(username))  
		  {  
//			  ((HttpServletResponse) response).sendRedirect("user.jsp");
//			  if(url.indexOf("user")<0){
//				   System.out.println("正在重定向：");  
//			  res.sendRedirect("user.jsp");
////			  return;//重定向使用
//			  }
		   // 跳转到登陆页面  
		   dispatcher.forward(request,response);  
		   System.out.println("用户没有登陆，不允许操作");  
		     
//		   res.setHeader("Cache-Control","no-store");     
//		   res.setDateHeader("Expires",0);  
//		   res.setHeader("Pragma","no-cache");  
		  }  
		  else  
		  {  
		   // 已经登陆,继续此次请求  
		   chain.doFilter(request,response);  
		   System.out.println("用户已经登陆，允许操作");  
//		   return;//重定向使用
		  }
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	public void destroy(){
		
	}
		 
 

}
