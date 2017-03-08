package com.ruicai.edu.service;
/*
 * 接口类
 */
import java.util.List;

import com.ruicai.edu.entity.BBS;
import com.ruicai.edu.entity.Teacher;

public interface BBS_Service {
	/*
	 * 查询方法接口
	 */
	public List<BBS> liuyanAll();
	
	/*
	 * 删除留言方法接口
	 */
    public int liuyanDelete(String ids);
    
    /*
     * 查找指定方法接口
     */
    public List<BBS> liuyanFind(String b_ly);
    /*
     * 在前台显示老师数据
     */
    public List<Teacher> liuyanShow(int t_id);
    
    /*
     * 显示留言
     */
     public List<BBS> liuyanOnclick(int t_id);
    /*
     * 添加留言
     */
     public int liuyanAdd(String text,String b_time,int s_id,int t_id);
}
