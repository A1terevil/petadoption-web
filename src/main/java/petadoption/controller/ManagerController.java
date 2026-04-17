package petadoption.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import jakarta.websocket.server.PathParam;
import petadoption.model.Manager;
import petadoption.service.ManagerService;

@Controller
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;

	 
	    //全
		@GetMapping("/user/admin_control")
		public String getAllManagers(Model model) {
			List<Manager> list = managerService.queryAll();
			model.addAttribute("list",list);
			return "admin_control";
		}	 
	 
	  
	 
	     //增
		 @PostMapping("/user/admin_control/mdo-add")
		 	public String insertManager(@ModelAttribute Manager m) {
			 System.out.println("新增的数据：--------"+m);
			 managerService.insertManager(m);
			 	return "redirect:/user/admin_control";
		 }
		 

		 
		 //删
		 @GetMapping("/admin_control/mdelete")
			public String deleteManagerByPid(@PathParam("mid") Integer mid) {
				managerService.deleteManager(mid);
				return "redirect:/user/admin_control";
			}
		 
		 

		 //查
		 @PostMapping("/user/mquery")
		 	public String queryManager(@RequestParam("mname") String mname,Model model) {
			 if(mname==""||mname.equals("姓名")) {				 
				 System.out.println("mname===========null");
				 return "redirect:/user/admin_control";
			 }
			 else{
				 System.out.println("mname==========="+mname);	
				 Manager manager = managerService.queryManager(mname);
				 model.addAttribute("man",manager);
				 return "mquery";
			 }
		 }
		 

		 //改		 
		 @PostMapping("/user/admin_control/mupdate")	  
		 public String updateManager(@ModelAttribute Manager m) {
			 System.out.println("修改后的数据:-------"+m);    
			 managerService.updateManager(m);
				return "redirect:/user/admin_control";
			}
}
