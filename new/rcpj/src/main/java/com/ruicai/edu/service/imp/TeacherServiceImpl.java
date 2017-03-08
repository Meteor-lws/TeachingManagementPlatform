/*package com.ruicai.edu.service.imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruicai.edu.getsqlsession.*;

import javax.servlet.http.HttpServlet;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.RequestContext;
import org.apache.ibatis.session.SqlSession;
import org.omg.CORBA.Request;

import com.ruicai.edu.dao.TeacherDao;
import com.ruicai.edu.entity.Teacher;
import com.ruicai.edu.service.TeacherService;

public class TeacherServiceImpl   implements TeacherService {
    SqlSession session;
    TeacherDao teacherDao;
    String returnString;
    
	public List<Teacher> queryTeacherList() {
		try {
			session=GetsqlSession.getSqlsession();
			teacherDao=session.getMapper(TeacherDao.class);
			return teacherDao.queryTeacherList();
		} catch (Exception e) {
			System.out.println("****************鏌ヨ鎵�湁鑰佸笀淇℃伅澶辫触*****************");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
	public String checkTeacherLoginName(String loginName) {
		returnString="isOK";
		try {
			session=GetsqlSession.getSqlsession();
			teacherDao=session.getMapper(TeacherDao.class);
			if(teacherDao.checkTeacherLoginName(loginName)>0) returnString="error";
		} catch (Exception e) {
			System.out.println("****************妫�煡鑰佸笀鐧诲綍鐢ㄦ埛鍚嶅け璐�****************");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return returnString;
	}
	
	public String addTeacher(Teacher teacher,File teacherIMG) {
		returnString="error";
        if(null==teacherIMG){
        	teacher.setT_photo("default.png");
        }else{
        	String fileName=teacher.getT_account()+teacher.getT_photo().substring(teacher.getT_photo().lastIndexOf("."));
        	//E:\JavaStudy\.metadata\.me_tcat7\webapps\rcjspj\WEB-INF\classes\images\teachers\caoyingyuan.jpg
        	String ImgUrl=getClass().getResource("/").getFile().toString();
        	ImgUrl=ImgUrl.substring(0,ImgUrl.indexOf("WEB-INF"))+"images/teachers/"+fileName;
        	System.out.println(ImgUrl);
        	File newFile=new File(ImgUrl);
        	System.out.println(newFile.exists());
        	fileChannelCopy(teacherIMG, newFile);
        	teacher.setT_photo(fileName);
        }
		//teacher.setT_photo(teacher.getT_account()+"");
		try {
			session=GetsqlSession.getSqlsession();
			teacherDao=session.getMapper(TeacherDao.class);
			teacher.setT_id(teacherDao.queryNextID());
			teacherDao.addTeacher(teacher);
			session.commit();
			returnString="isOK";
		} catch (Exception e) {
			System.out.println("****************娣诲姞鑰佸笀澶辫触*****************");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return returnString;
	}
    
	public String updateTeacher(Teacher teacher, File teacherIMG) {
		returnString="error";
		if(null==teacherIMG){
			if (teacher.getT_photo().equals("")) teacher.setT_photo("default.png");
        }else{
        	String fileName=teacher.getT_account()+teacher.getT_photo().substring(teacher.getT_photo().lastIndexOf("."));
        	//E:\JavaStudy\.metadata\.me_tcat7\webapps\rcjspj\WEB-INF\classes\images\teachers\caoyingyuan.jpg
        	String ImgUrl=getClass().getResource("/").getFile().toString();
        	ImgUrl=ImgUrl.substring(0,ImgUrl.indexOf("WEB-INF"))+"images/teachers/"+fileName;
        	File newFile=new File(ImgUrl);
        	if (newFile.exists()) {
				newFile.delete();
			}
        	fileChannelCopy(teacherIMG, newFile);
        	teacher.setT_photo(fileName);
        }
		//teacher.setT_photo(teacher.getT_account()+"");
		try {
			session=GetsqlSession.getSqlsession();
			teacherDao=session.getMapper(TeacherDao.class);
			teacherDao.updateTeacher(teacher);
			session.commit();
			returnString="isOK";
		} catch (Exception e) {
			System.out.println("****************鏇存柊鑰佸笀淇℃伅澶辫触*****************");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return returnString;
	}
    public JSONObject getTeacherByID(int id,JSONObject jsonObject) {
		JSONObject jsonObject2=null;
		try {
			Map<String, Object> map=new HashMap<String, Object>();
			session=GetsqlSession.getSqlsession();
			teacherDao=session.getMapper(TeacherDao.class);
			Teacher teacher=teacherDao.getTeacherByID(id);
			map.put("teacher.t_id", teacher.getT_id());
			map.put("teacher.t_name", teacher.getT_name());
			map.put("teacher.t_sex", teacher.getT_sex());
			map.put("teacher.t_jianJie", teacher.getT_jianJie());
			map.put("teacher.t_photo", teacher.getT_photo());
			map.put("teacher.t_account", teacher.getT_account());
			map.put("teacher.t_pass", teacher.getT_pass());
			map.put("teacher.t_zhuanYe", teacher.getT_zhuanYe());
			map.put("teacher.t_leiXing", teacher.getT_leiXing());
			map.put("teacher.t_phone", teacher.getT_phone());
			map.put("teacher.t_class", teacher.getT_class());
            jsonObject2=JSONObject.fromObject(map);
		} catch (Exception e) {
			System.out.println("****************鏍规嵁ID鏌ヨ鑰佸笀澶辫触*****************");
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return jsonObject2;
	}
    
  
	
    public String deleteTeacher(String ids) {
    	returnString="error";
		ids=ids.substring(0,ids.length()-1);
		String[] id=ids.split(",");
		List<String> list=new ArrayList<String>();
		Collections.addAll(list, id);
		try {
			session=GetsqlSession.getSqlsession();
			teacherDao=session.getMapper(TeacherDao.class);
			int num=teacherDao.deleteTeacher(id);
			
			session.commit();
			returnString="isOK";
		} catch (Exception e) {
			System.out.println("****************鍒犻櫎鑰佸笀澶辫触*****************");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return returnString;
	}
    public List<Teacher> loadTeachersByFilter(String teacherName, String ZY,
			String LX) {
    	List<Teacher> teachers=null;
    	try {
    		session=GetsqlSession.getSqlsession();
			teacherDao=session.getMapper(TeacherDao.class);
		    ZY=ZY.equals("ALL")?"":ZY;
		    LX=LX.equals("ALL")?"":LX;
		    Map<String, String> map =new HashMap<String, String>();
		    map.put("teacherName", "%"+teacherName+"%");
		    map.put("ZY", ZY);
		    map.put("LX", LX);
		    teachers=teacherDao.loadTeachersByFilter(map);

		} catch (Exception e) {
			System.out.println("****************鏍规嵁鏉′欢鏌ヨ鑰佸笀澶辫触*****************");
			e.printStackTrace();
		}finally{
			session.close();
		}
		// TODO Auto-generated method stub
		return teachers;
	}
    public JSONObject loadTeachersByPages(int page,int rows) {
    	Map<String, Object> map1=new HashMap<String, Object>();
    	List<Teacher> teachers=null;
    	int total=0;
    	try {
    		System.out.println("鍒嗛〉鏌ヨ杩涙潵浜�");
    		session=GetsqlSession.getSqlsession();
			teacherDao=session.getMapper(TeacherDao.class);
		    Map<String, Integer> map =new HashMap<String, Integer>();
		    Integer startNum=(page-1)*rows+1;
		    Integer endNum=(page)*rows;
		    map.put("startNum", startNum);
		    map.put("endNum", endNum);
		    teachers=teacherDao.loadTeachersByPages(map);
		    total=teacherDao.getSumTeachersCount();
		} catch (Exception e) {
			System.out.println("***************鍒嗛〉鏌ヨ鑰佸笀澶辫触*****************");
			e.printStackTrace();
		}finally{
			session.close();
		}
    	map1.put("total", total);
		map1.put("rows", teachers);
		
		JSONObject jsonObject=new JSONObject();
		jsonObject=JSONObject.fromObject(map1);
		return jsonObject;
		
	}
    
   
	public List<Teacher> loadTeachersByStudentID(int id) {
    	List<Teacher> teachers=new ArrayList<Teacher>();
		try {
			session=GetsqlSession.getSqlsession();
			teacherDao=session.getMapper(TeacherDao.class);
			teachers=teacherDao.loadTeachersByStudentID(id);
		} catch (Exception e) {
			System.out.println("****************鏍规嵁瀛︾敓ID鏌ヨ鑰佸笀淇℃伅澶辫触*****************");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return teachers;
	}
   

	*//**
	 * 灏嗙敤鎴峰浘鐗囩Щ鍒版湇鍔″櫒
	 * @param oldFile
	 * @param newFile
	 * @return
	 *//*
	public boolean fileChannelCopy(File oldFile,File newFile) {
		boolean copyOK=false;
		FileInputStream fis=null;
		FileOutputStream fos=null;
		FileChannel  in=null;
		FileChannel  out=null;
		try {
			fis=new FileInputStream(oldFile);
			fos=new FileOutputStream(newFile);
			in=fis.getChannel();
			out=fos.getChannel();
			in.transferTo(0, in.size(), out);
			copyOK=true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("****************绉诲姩鏁欏笀鐓х墖鏂囦欢澶辫触*****************");
			e.printStackTrace();
		}finally{
			try {
				fis.close();
				fos.close();
				out.close();
				in.close();
			} catch (Exception e2) {
				System.out.println("****************绉诲姩鏁欏笀鐓х墖鏂囦欢澶辫触*****************");
				e2.printStackTrace();
			}
		}
		return copyOK;
	}

	public List<Teacher> loadAllteachersForSelect() {
		List<Teacher> teachers=new ArrayList<Teacher>();
		try {
			session=GetsqlSession.getSqlsession();
			teacherDao=session.getMapper(TeacherDao.class);
			teachers=teacherDao.loadAllteachersForSelect();
		} catch (Exception e) {
			System.out.println("****************鏌ヨ鑰佸笀淇℃伅澶辫触*****************");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return teachers;
	}

	

	
	
	
	
	
	
	
}
*/