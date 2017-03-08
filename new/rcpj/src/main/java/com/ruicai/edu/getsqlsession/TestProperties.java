package com.ruicai.edu.getsqlsession;

import java.security.MessageDigest;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

//在src下，可以试着调试登录

public class TestProperties {
	private String param1;
	private String param2;

//	/**
//	 * 私有构造方法，不需要创建对象
//	 */

	public String getParam1() {
		return param1;
	}

	public String getParam2() {
		return param2;
	}

	// md5
	public String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	
	public static void main(String args[]) {
		TestProperties properties =new TestProperties().getTestProperties();
		System.out.println(properties.MD5("123456"));
		if ((new TestProperties().MD5("123456")).equals(properties.getParam2())) {
			System.out.println("keyi de l ");
		}
		if (properties.MD5("123456").equals(properties.getParam2())
				&& properties.getParam1().equals("root")) {
			System.out.println("完成了");
		}
	}
	
	
	public TestProperties getTestProperties(){	
		Properties prop = new Properties();
		InputStream in = Object.class.getResourceAsStream("/md5.properties");
		
		
		try {
			prop.load(TestProperties.class.getClassLoader().getResourceAsStream("/md5.properties"));
			//prop.load(in);
			param1 = prop.getProperty("adminName").trim();
			param2 = prop.getProperty("adminPass").trim();
		} catch (IOException e) {
			System.out.println("TestProperties的getTestProperties出现异常");
			e.printStackTrace();
		}
		System.out.println(this);
		return this;	
		
	}
}