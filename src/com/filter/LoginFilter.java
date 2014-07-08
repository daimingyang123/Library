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
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");//�����������û�е�½��Ҫת������ҳ��  
		  HttpServletRequest req = (HttpServletRequest) request;  
		  HttpServletResponse res = (HttpServletResponse) response;  
		  HttpSession session = req.getSession(true);
		  //��ȡ��ǰURL
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
			  System.out.println("��¼���棡");  
			  chain.doFilter(request,response);
			  return;
		  }
		  // ��session��ȡ���û�����Ϣ  
		  String username = (String) session.getAttribute("username");
		// �ж����û��ȡ���û���Ϣ,����ת����½ҳ��  
		  if (username == null || "".equals(username))  
		  {  
//			  ((HttpServletResponse) response).sendRedirect("user.jsp");
//			  if(url.indexOf("user")<0){
//				   System.out.println("�����ض���");  
//			  res.sendRedirect("user.jsp");
////			  return;//�ض���ʹ��
//			  }
		   // ��ת����½ҳ��  
		   dispatcher.forward(request,response);  
		   System.out.println("�û�û�е�½�����������");  
		     
//		   res.setHeader("Cache-Control","no-store");     
//		   res.setDateHeader("Expires",0);  
//		   res.setHeader("Pragma","no-cache");  
		  }  
		  else  
		  {  
		   // �Ѿ���½,�����˴�����  
		   chain.doFilter(request,response);  
		   System.out.println("�û��Ѿ���½���������");  
//		   return;//�ض���ʹ��
		  }
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	public void destroy(){
		
	}
		 
 

}
