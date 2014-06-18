package com.action;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	private String admin;
	private String password;
	private static Properties properties;
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


//	public String getMotto() {
//		return "" + properties.get("motto");
//	}
//	
//	public String getAdminName() {
//		return "" + properties.get("username");
//	}
//	
	public static String getdefaultAdminname() {  
        return "" + properties.get("adminname");  
    }
//	public static String getdefaultEmail() {  
//        return "" + properties.get("email");  
//    }  
//	
	
	public static String getdefaultAdminpassword() {  
        return "" + properties.get("adminpassword");  
    }  
	@Override
	public String execute() throws Exception {
		InputStream in = AdminAction.class.getClassLoader().getResourceAsStream("admin.properties");
        properties = new Properties();  
        properties.load(in);
        if((admin.equals(getdefaultAdminname()) && password.equals(getdefaultAdminpassword())) ){
            ActionContext.getContext().getSession().put(admin,"admin");
            return SUCCESS;
		}
		else{
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("error", "password wrong¯¯");
		return INPUT;
		}
		}
}
