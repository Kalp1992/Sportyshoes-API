package com.sportyshoes.controllers.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping("") 
	public String index() {
    	  return "Hello visitor! Welcome to Sportyshoes. Get the best sports shoes";
      }
}
