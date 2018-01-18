package com.dqs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dqs.service.UserService;
import com.dqs.util.Status;
@Controller
@RequestMapping("/home/AdminController")
public class AdminController {
	@Autowired
	private UserService us;
	private Status status;
	AdminController (){
		status = new Status();
	}
}
