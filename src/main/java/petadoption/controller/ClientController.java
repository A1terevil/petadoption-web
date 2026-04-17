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
import petadoption.model.Client;
import petadoption.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
 
	    //全
		@GetMapping("/user/client")
		public String getAllClients(Model model) {
			List<Client> list = clientService.queryAll();
			model.addAttribute("list",list);
			return "user";
		}	 
	 
	  
	 
	     //增
		 @PostMapping("/user/client/cdo-add")
		 	public String insertClent(@ModelAttribute Client c) {
			 System.out.println("新增的数据：--------"+c);
			 clientService.insertClient(c);
			 	return "redirect:/user/client";
		 }
		 

		 
		 //删
		 @GetMapping("/client/cdelete")
			public String deleteClientByNaT(@PathParam("cname") String cname,@PathParam("tel") String tel) {
				clientService.deleteClient(cname,tel);
				return "redirect:/user/client";
			}
		 
		 

		 //查
		 @PostMapping("/user/cquery")
		 	public String queryManager(@RequestParam("cname") String cname,@RequestParam("tel") String tel,Model model) {
			 if(cname==""&&tel=="") {				 
				 System.out.println("cname===========null");
				 System.out.println("tel===========null");
				 return "redirect:/user/client";
			 }
			 else{
				 System.out.println("cname==========="+cname);
				 System.out.println("tel==========="+tel);
				 Client client = clientService.queryClient(cname,tel);
				 model.addAttribute("cli",client);
				 return "cquery";
			 }
		 }
		 

		 //改		 
		 @PostMapping("/user/client/cupdate")	  
		 public String updateClients(@ModelAttribute Client c) {
			 System.out.println("修改后的数据:-------"+c);    
			 clientService.updateClient(c);
				return "redirect:/user/client";
			}
	
}


