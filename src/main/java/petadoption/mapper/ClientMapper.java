package petadoption.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import petadoption.model.Client;

@Mapper
public interface ClientMapper {
	
	Client getClientByNaT(String cname,String tel);
	
	List<Client> getAllClients();
	
	void deleteClientByNaT(String cname,String tel);
	   
	void updateClientByCid(Client c);
	   
	void insertClient(Client c);

}
