package com.ruicai.edu.filter;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.ruicai.edu.entity.Student;

public class StudentIntercept extends  AbstractInterceptor{
			

		@Override
		public String intercept(ActionInvocation ai) throws Exception {
			Map session = ai.getInvocationContext().getSession();
			Student	student = (Student) session.get("student");
			if(student != null){
				return ai.invoke();
			}else{
				return "student_login_error";
			}
		}
			
		}
	

