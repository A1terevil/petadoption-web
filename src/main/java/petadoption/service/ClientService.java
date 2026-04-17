package petadoption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petadoption.mapper.ClientMapper;
import petadoption.model.Client;

@Service
public class ClientService {
	
	@Autowired
	private ClientMapper clientMapper;
	
	public Client queryClient(String cname,String tel) {
		return clientMapper.getClientByNaT(cname,tel);
	}
	
	public List<Client> queryAll(){
		return clientMapper.getAllClients();
	}
	
	public void  deleteClient(String cname,String tel) {
		 clientMapper.deleteClientByNaT(cname,tel);
	}
	
	public void  updateClient(Client c) {
		 clientMapper.updateClientByCid(c);
	}
	
	public void insertClient(Client c) {
		clientMapper.insertClient(c);
	}

}
