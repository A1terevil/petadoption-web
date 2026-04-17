package petadoption.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.websocket.server.PathParam;
import petadoption.model.Pet;
import petadoption.service.PetService;


@Controller
public class PetController {
	
	@Autowired
	private PetService petService;
	 
	 
		@GetMapping("/user/pet")
		public String getAllPets(Model model) {
			List<Pet> list = petService.queryAll();
			model.addAttribute("list",list);
			return "pet";
		}
		
		
		@GetMapping("/pet")
		@ResponseBody
		public List<Pet> getAllPet(Model model) {
			List<Pet> list = petService.queryAll();
			System.out.println(list.getClass().toString());
			return list;
		}
		


		 @PostMapping("/user/pet/pdo-add")
		 	public String insertPet(@ModelAttribute Pet p) {
			 System.out.println("新增的数据：--------"+p);
			 petService.insertPet(p);
			 	return "redirect:/user/pet";
		 }
		 

		 
		 
		 @GetMapping("/pet/pdelete")
			public String deletePetByPid(@PathParam("pid") Integer pid) {
				petService.deletePet(pid);
				return "redirect:/user/pet";
			}
		 
		 

		 
		 @PostMapping("/user/pquery")
		 	public String queryPet(@RequestParam("pname") String pname,Model model) {
			 if(pname==""||pname.equals("宠物名")) {				 
				 System.out.println("pname===========null");
				 return "redirect:/user/pet";
			 }
			 else{
				 System.out.println("pname==========="+pname);	
				 Pet pet = petService.queryPet(pname);
				 model.addAttribute("pet",pet);
				 return "pquery";
			 }
		 }
		 

		 		 
		 @PostMapping("/user/pet/pupdate")	  
		 public String updatePet(@ModelAttribute Pet p) {
			 System.out.println("修改后的数据:-------"+p);    
			 petService.updatePet(p);
				return "redirect:/user/pet";
			}
			 

}
