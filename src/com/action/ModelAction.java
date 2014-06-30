package com.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.ServiceManager;

@SuppressWarnings("serial")
public class ModelAction<Model> extends ActionSupport implements ModelDriven<Model>,ServletRequestAware,ServletContextAware{
	protected Model model;
	protected static ServiceManager serviceManager;
	protected String result;
	protected HttpServletRequest request;
	protected HttpSession session;
    protected ServletContext context;
	@Override
	public void setServletContext(ServletContext context)
	{
	    this.context = context;			
	}

	@Override
	public Model getModel()
	{
		return model;
	}

	public void setServiceManager(ServiceManager serviceManager)
	{
		ModelAction.serviceManager = serviceManager;
	}

	@Override
	public void setServletRequest(HttpServletRequest request)
	{
	    this.request = request;
	    this.session = request.getSession();		
	}

	public String getResult()
	{
		result = "fuck";
		return result;
	}
}
