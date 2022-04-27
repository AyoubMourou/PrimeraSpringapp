package com.example.PrimeraAppSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	/* 
	 * Busca en la carpeta templates 
	 * un archivo llamado HTML con GetMapping 
	 * y al ponerle que devuelve un string
	 */
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/userForm")
	public String userForm() {
		return "user-form/user-view";
	}
}
