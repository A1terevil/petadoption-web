package petadoption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petadoption.mapper.PetMapper;
import petadoption.model.Pet;

@Service
public class PetService {
	
	@Autowired
	private PetMapper petMapper;
	
	public Pet queryPet(String pname) {
		return petMapper.getPetByPname(pname);
	}
	
	public List<Pet> queryAll(){
		return petMapper.getAllPets();
	}
	
	public void  deletePet(Integer pid) {
		 petMapper.deletePetByPid(pid);
	}
	
	public void  updatePet(Pet p) {
		 petMapper.updatePetByPid(p);
	}
	
	public void insertPet(Pet p) {
		petMapper.insertPet(p);
	}
	

}
