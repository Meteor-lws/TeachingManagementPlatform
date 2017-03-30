package com.ruicai.edu.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.ruicai.edu.entity.Evaluate;
import com.ruicai.edu.service.EvaluateService;
import com.ruicai.edu.service.imp.EvaluateServiceImp;

public class EvaluateAction {

	EvaluateService evaluateService = new EvaluateServiceImp();
	private List<Evaluate> evaluates;
	private String msg;
	private JSONObject jsonMessage;
	private String ids;
	private Evaluate evaluate;
	private String id;
	



	/**
	 * 后台管理员点击评价管理跳转
	 * @return String
	 */
	public String loadManager(){
		System.out.println("跳转成功");
		return "loadManager";
	}
	
	/**
	 * 加载所有的评价信息
	 * @return String
	 */
	
	public String loadEvaluates(){
		evaluates = evaluateService.queryEvaluateList();
		System.out.println("加载评价信息成功");
		return "loadEvaluates";
	}
	
	
	/**
	 * 加载所有评价项，供学生登陆评价
	 * @return
	 */
	public String execute(){
		String id=ActionContext.getContext().getSession().get("teacherId").toString();
		evaluates = evaluateService.queryEvaluateListByTeacherID(id);
		/*evaluates = evaluateService.queryEvaluateList(id);
		for (int i = 0; i < evaluates.size(); i++) {
			if(evaluates.get(i).getE_use()==0){
				evaluates.remove(i);
			}
		}*/
		Map<String, Object>session=ActionContext.getContext().getSession();
		session.put("evaluates", evaluates);
		return "loadEvaluatesStu";
	}
	
	
	/**
     * 删除评分项信息操作
     * @return
     */
    public String deleteEvaluate() {
    	msg=evaluateService.deleteEvaluate(ids);
   	 	return "deleteEvaluate";
	}
    
    /**
     * 添加评分项信息操作
     * @return
     */
    public String addEvaluate(){
//    	System.out.println("进来了。。");
//    	System.out.println(evaluate.getE_nape()+"----"+evaluate.getE_type()+"-----"+evaluate.getE_use());
   	 	msg=evaluateService.addEvaluate(evaluate);
   	 	return "addEvaluate";
    }
    
    /**
     * 修改评分项操作
     * @return
     */
    
    public String updateEvaluate(){
    	System.out.println("update进来了。。。");
    	msg = evaluateService.updateEvaluate(evaluate);
    	return "updateEvaluate";
    }
    
    
	//--------get/set进行封装-----------------------
	public List<Evaluate> getEvaluates() {
		return evaluates;
	}
	public void setEvaluates(List<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public JSONObject getJsonMessage() {
		return jsonMessage;
	}

	public void setJsonMessage(JSONObject jsonMessage) {
		this.jsonMessage = jsonMessage;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	public Evaluate getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(Evaluate evaluate) {
		this.evaluate = evaluate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
