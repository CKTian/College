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
 * ִ�д���controller 
 * ��ǰ̨���ش�����Ϣ
 * @author ���첩
 * 2018��1��16��
 */
@Controller
@RequestMapping("/ErrorController")
public class ErrorController {
	@RequestMapping("/sendError.do")
	@ResponseBody
	public Map sendError(HttpServletRequest req){
		//��ȡ�����е�״̬��Ϣ
		Map map = (Map) req.getAttribute("status");
		//���ظ�ǰ̨
		return map;
	}
}
