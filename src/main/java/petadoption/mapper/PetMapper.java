package petadoption.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import petadoption.model.Pet;

@Mapper
public interface PetMapper {
	
	Pet getPetByPname(String pname);
	
	List<Pet> getAllPets();
	
	void deletePetByPid(Integer pid);
	   
	void updatePetByPid(Pet p);
	   
	void insertPet(Pet p);

}
