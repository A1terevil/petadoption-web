package petadoption.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.websocket.server.PathParam;
import petadoption.model.Client;
import petadoption.model.Pet;
import petadoption.service.ClientService;
import petadoption.service.PetService;

@Controller
public class ShowController {
	@Autowired
	private PetService petService;
	
	@Autowired
	private ClientService clientService;
	 
	 
		@GetMapping("/show")
		public String getAllPets(Model model) {
			List<Pet> list = petService.queryAll();
			model.addAttribute("list",list);
			return "show";
		}
		
		 @PostMapping("/show/cdo-add")
		 	public String insertClient(@ModelAttribute Client c) {
			 System.out.println("新增的数据：--------"+c);
			 clientService.insertClient(c);
			 	return "redirect:/show";
		 }
		 
		 @PostMapping("/show/cdelete")
			public String deleteClientByNaT(@PathParam("cname") String cname,@PathParam("tel") String tel) {
				clientService.deleteClient(cname,tel);
				return "redirect:/show";
			}		 	
		
		

}
