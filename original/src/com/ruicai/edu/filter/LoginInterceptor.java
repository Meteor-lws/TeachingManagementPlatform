package com.ruicai.edu.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor  implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = invocation.getInvocationContext();  
        HttpServletRequest request = (HttpServletRequest)context.get(ServletActionContext.HTTP_REQUEST);  
        //获取session  
        HttpSession session = request.getSession();  
        //获取请求的路径  
        String path = request.getRequestURI();  
        System.out.println("进来了");
        //判断是否登录,如果登录判断是否有访问的权限  
        if(session.getAttribute("student")== null &&session.getAttribute("admin") == null){  
            // 重定向到登录界面  
        	System.out.println("可以放我走了");
            //request.getRequestDispatcher("/login.jsp"); 此方式用下面的 Action.LOGIN;代替  
            return Action.LOGIN;  
        }else{  
             
        return invocation.invoke();  
    }  
	}
}
