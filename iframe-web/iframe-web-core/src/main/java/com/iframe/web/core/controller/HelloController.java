package com.iframe.web.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author janko
 * @date 18/11/2017
 * @desc
 */
@Controller
@RequestMapping("/")
public class HelloController {


	@RequestMapping(value = "helloworld.vpage", method = {RequestMethod.GET})
	@ResponseBody
	public String helloworld() {

		return "hello world";
	}

	@RequestMapping(value = "index.vpage", method = {RequestMethod.GET})
	public String index() {

		return "index";
	}

	@RequestMapping(method = {RequestMethod.GET})
	public String home() {

		return "home";
	}
}
