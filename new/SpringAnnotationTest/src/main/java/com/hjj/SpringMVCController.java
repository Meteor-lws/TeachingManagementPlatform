package com.hjj;

import com.alibaba.fastjson.JSON;
import com.hjj.vo.EasyUI;
import com.hjj.vo.Tree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱高 on 2017/3/16.
 */
@Controller
public class SpringMVCController {

    @RequestMapping(value="/test", method = RequestMethod.POST)
    @ResponseBody
    public String test(EasyUI easyUI){
        System.out.println(easyUI);
        if (easyUI.getManager().equals("zg") && easyUI.getPassword().equals("123456")){
            return "0";
        }
        return "1";
    }

    @RequestMapping(value="/tree", method = RequestMethod.POST)
    @ResponseBody
    public String jsonTest(EasyUI easyUI){
        List<Tree> list = new ArrayList<Tree>();
        System.out.println("easyUI = [" + easyUI + "]");
        if(easyUI.getId() == 0){
            Tree tree = new Tree();
            tree.setText("系统管理");
            tree.setId(1);
            tree.setState("closed");
            tree.setNid(0);
            list.add(tree);
            Tree tree2 = new Tree();
            tree2.setText("会员管理");
            tree2.setId(3);
            tree2.setState("closed");
            tree2.setNid(0);
            list.add(tree2);
        }else if(easyUI.getId() == 1){
            Tree tree1 = new Tree();
            tree1.setText("用户管理");
            tree1.setId(2);
            tree1.setState("open");
            tree1.setUrl("data.jsp");
            tree1.setNid(1);
            list.add(tree1);
        }else if(easyUI.getId() == 3){
            Tree tree3 = new Tree();
            tree3.setText("会员信息");
            tree3.setNid(3);
            tree3.setId(4);
            tree3.setUrl("s");
            tree3.setState("open");
            list.add(tree3);
        }/*else if(easyUI.getId() == 2){
            Tree tree4 = new Tree();
            tree4.setText("成员信息");
            tree4.setNid(2);
            tree4.setId(5);
            tree4.setUrl("s");
            tree4.setState("open");
            list.add(tree4);
        }*/
        String json = JSON.toJSONString(list);
        System.out.println(json);
        return json;
    }
    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(EasyUI easyUI){
        System.out.println("easyUI11 = [" + easyUI + "]");

        return "1";
    }
}
