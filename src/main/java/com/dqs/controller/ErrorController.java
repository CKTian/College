package com.dqs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqs.entity.User;
import com.dqs.util.Status;
/**
 * 
 * 执行错误controller 
 * 向前台返回错误信息
 * @author 王天博
 * 2018年1月16日
 */
@Controller
@RequestMapping("/ErrorController")
public class ErrorController {
	@RequestMapping("/sendError.do")
	@ResponseBody
	public Map sendError(HttpServletRequest req){
		//获取请求中的状态信息
		Map map = (Map) req.getAttribute("status");
		//返回给前台
		return map;
	}
}
