package petadoption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petadoption.mapper.ManagerMapper;
import petadoption.model.Manager;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerMapper managerMapper;
	
	public Manager queryManager(String mname) {
		return managerMapper.getManagerByMname(mname);
	}
	
	public List<Manager> queryAll() {
		return managerMapper.getAllManagers();
	}
	
	public void  deleteManager(Integer mid) {
		 managerMapper.deleteManagerByMid(mid);
	}
	
	public void  updateManager(Manager m) {
		 managerMapper.updateManagerByMid(m);
	}
	
	public void insertManager(Manager m) {
		managerMapper.insertManager(m);
	}

}
