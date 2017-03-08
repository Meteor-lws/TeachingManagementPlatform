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
        //鑾峰彇session  
        HttpSession session = request.getSession();  
        //鑾峰彇璇锋眰鐨勮矾寰� 
        String path = request.getRequestURI();  
        System.out.println("杩涙潵浜�");
        //鍒ゆ柇鏄惁鐧诲綍,濡傛灉鐧诲綍鍒ゆ柇鏄惁鏈夎闂殑鏉冮檺  
        if(session.getAttribute("student")== null &&session.getAttribute("admin") == null){  
            // 閲嶅畾鍚戝埌鐧诲綍鐣岄潰  
        	System.out.println("鍙互鏀炬垜璧颁簡");
            //request.getRequestDispatcher("/login.jsp"); 姝ゆ柟寮忕敤涓嬮潰鐨�Action.LOGIN;浠ｆ浛  
            return Action.LOGIN;  
        }else{  
             
        return invocation.invoke();  
    }  
	}
}
