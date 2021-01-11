package com.supreet.springboot.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")

public class TodoController {
	@Autowired
	TodoService service;
	
	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name= (String)model.get("name");
		model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}
	@RequestMapping(value="/add-todos", method = RequestMethod.GET)
	public String showAddTodos(ModelMap model) {
		String name= (String)model.get("name");
		model.put("todos", service.retrieveTodos(name));
		return "add-todos";
	}
	
	@RequestMapping(value="/add-todos", method = RequestMethod.POST)
	public String addTodos(ModelMap model, @RequestParam String desc) {
		String name= (String)model.get("name");
		service.addTodo(name, desc, new Date(), false);
//		model.put("todos", service.retrieveTodos(name));
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodos(ModelMap model, @RequestParam int id) {
		String name= (String)model.get("name");
		service.deleteTodo(id);
//		model.put("todos", service.retrieveTodos(name));
		return "redirect:/list-todos";
	}


}
