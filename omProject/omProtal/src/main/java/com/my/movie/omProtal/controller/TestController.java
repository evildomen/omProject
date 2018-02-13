package com.my.movie.omProtal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TestController {
	@RequestMapping(value="index")
	public String testIndex() {
		return "index";
	}
}
