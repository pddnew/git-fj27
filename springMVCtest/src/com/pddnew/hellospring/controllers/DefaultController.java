package com.pddnew.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pddnew.hellospring.model.Person;

@Controller
public class DefaultController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(ModelMap map){
		map.addAttribute("hello","Hello Spring!");
		return "index";
	}
	
	@RequestMapping(value="/viewdemo", method=RequestMethod.GET)
	public String demo(ModelMap map){		
		map.put("personObject", initPerson("Rod Johnson", 2013-1986));
		map.addAttribute("helloAgain", "Hello Spring again");
		return "demo";
	}
	
	@RequestMapping(value="/person/{name}", method=RequestMethod.GET)
	public String demo(@PathVariable(value="name") String name, ModelMap map){
		map.put("personObject", initPerson(name, 0));
		map.addAttribute("helloAgain", "Hello Spring again. /person/{name}");
		return "demo";
	}

	@RequestMapping(value="/person/{name}/{age}", method=RequestMethod.GET)
	public String demo(@PathVariable(value="name") String name, @PathVariable(value="age") int age, ModelMap map){
		map.put("personObject", initPerson(name, age));
		map.addAttribute("helloAgain", "Hello Spring again. /person/{name}/{age}");
		return "demo";
	}	
	
	private Person initPerson(String name, int age){
		Person p = new Person();
		p.setName(name);
		p.setAge(age);
		return p;
	}
}

