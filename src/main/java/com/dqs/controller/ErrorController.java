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
 * 返回错误的信息
 * @author 王天博
 * 2018年1月25日
 */
@Controller
@RequestMapping("/ErrorController")
public class ErrorController {
	@RequestMapping("/sendError.do")
	@ResponseBody
	public Map sendError(HttpServletRequest req){
		// 从请求头中获取错误信息
		Map map = new HashMap();
		Status status = (Status) req.getAttribute("status");
		map.put("status", status);
		// 返回给前台
		return map;
	}
}
