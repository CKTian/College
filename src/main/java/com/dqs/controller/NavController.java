package com.dqs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqs.entity.Nav;
import com.dqs.service.NavService;
import com.dqs.service.UserService;
import com.dqs.util.Status;
@Controller
@RequestMapping("/home/NavController")
public class NavController {
	@Autowired
	private NavService ns;
	private Status status;
	NavController (){
		status = new Status();
	}
	/**
	 * 
	 * @Title: selectNav  
	 * @Description: TODO
	 * @author 王天博
	 * @param @param req      
	 * @return void
	 */
	@RequestMapping("/selectNav.do")
	@ResponseBody
	public Map selectNav(HttpServletRequest req){
		Map map = new HashMap();
		Map user  = (Map) req.getAttribute("user");
		Integer role_id =  (Integer) user.get("role_id");//获取当前登录的用户的权限值
		List<Nav> navlist = ns.selectList(role_id); //查询出对应权限的navlist
		//解析 navlist
		List newNavlist = createNavList(navlist,1,0);
		map.put("newNavlist", newNavlist);
		//状态值
		status.setValue("1");
		map.put("status", status);
		return map;
	}
	/**
	 * 
	 * @Title: createNavList  
	 * @Description: 递归算法--生成新的nav格式
	 * @author 王天博
	 * @param @param navlist
	 * @param @param level
	 * @param @param parentId
	 * @param @return      
	 * @return List
	 */
	public List createNavList (List navlist, Integer level,Integer parentId){
		List list=new ArrayList();
		for(int i = 0 ; i < navlist.size() ; i++) {
			Nav nav = (Nav) navlist.get(i);
			if (nav.getLevel() == level && nav.getParentId() == parentId) {
				  List childList=new ArrayList();
				  Integer id = (Integer) nav.getId();
				  childList = createNavList(navlist, level + 1,id );
				  Map map = new HashMap();
				  map.put("liName", nav.getName());
				  map.put("liHref", nav.getHref());
				  map.put("iconClass", nav.getIcon());
				  map.put("children", childList);
				  list.add(map);
			}
		}
		return list;
	}
}
