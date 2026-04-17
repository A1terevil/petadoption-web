package petadoption.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import petadoption.model.Manager;
import petadoption.service.ManagerService;


@Controller
public class HelloController {
	
	@Autowired
	private ManagerService managerService;
	
	
	@GetMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return "<h1 style='color:red;width:360px;height:80px;margin:50px auto;'>Hello SpringBoot:)</h1>";
	}
	
	 
	 @GetMapping("/index")
	    public String main()
	    {
	        return "index";
	    }
	 
	 @GetMapping("/login")
	    public String login(Model model)
	    {
			List<Manager> list = managerService.queryAll();
			model.addAttribute("list",list);
	        return "login";
	    }	 

}
