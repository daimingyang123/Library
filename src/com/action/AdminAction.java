package com.action;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
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


	public static String getdefaultAdminname() {  
        return "" + properties.get("adminname");  
    }
	
	public static String getdefaultAdminpassword() {  
        return "" + properties.get("adminpassword");  
    }  
	@Override
	public String execute() throws Exception {
		InputStream in = AdminAction.class.getClassLoader().getResourceAsStream("admin.properties");
        properties = new Properties();  
        properties.load(in);
        if((admin.equals(getdefaultAdminname()) && password.equals(getdefaultAdminpassword())) ){
            HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("userName", "admin");
            return SUCCESS;
		}
		else{
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("error", "ユーザー名やパスワードエラー");
			return ERROR;
		}
		}
}
