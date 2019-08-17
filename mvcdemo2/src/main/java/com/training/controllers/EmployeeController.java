package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.DAO.EmployeeDAO;
import com.training.beans.Emp;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDAO dao;
	
	 @RequestMapping("/empform")    
	    public String showform(Model m){    
	        m.addAttribute("command", new Emp());  
	        return "empedit";   
	    }   
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("Emp") Emp emp)
	{
		dao.save(emp);
		return "redirect:/select";    
	}
	
	@RequestMapping("/select")
	public String showAllEmployee(Model m)
	{
		
		List<Emp> list=dao.queryall();
		for(int i=0;i<list.size();i++){
			   System.out.println(list.get(i).getId());
		}
		m.addAttribute("ist",list);
		
		return "showemp";
	}
			
	
	@RequestMapping("/editemp/{id}")
	public String editEmp(@PathVariable int id, Model m)
	{
		Emp emp=dao.getEmpByID(id);
		m.addAttribute("command", emp);
		return "empeditform";
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") Emp emp){    
        dao.update(emp);    
        return "redirect:/select";    
    }    
	
	@RequestMapping("/deleteemp/{id}")
	public String deleteEmp(@PathVariable int id, Model m)
	{
		int temp=dao.delete(id);
		System.out.println("deleted *********"+temp);
		return "redirect:/select";  
	}
	
	@RequestMapping("/404")
    public String error404(){
     
        return "index";
    }
	
}
