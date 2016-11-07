package com.popolong.studio.microservice.smartSerivces.controller;

import java.util.logging.Logger;

import com.popolong.studio.microservice.smartSerivces.service.SmartRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	protected Logger logger = Logger.getLogger(HomeController.class
			.getName());
	@Autowired
	protected SmartRepoService topUpRepoService;
	
	@RequestMapping("/")
	public String home() {
		logger.info("go to index");
		return "index";
	}

}
