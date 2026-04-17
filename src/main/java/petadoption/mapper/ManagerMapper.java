package petadoption.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import petadoption.model.Manager;

@Mapper
public interface ManagerMapper {
	
	   Manager getManagerByMname(String mname);
	   
	   List<Manager> getAllManagers();
	   
	   void deleteManagerByMid(Integer mid);
		   
	   void updateManagerByMid(Manager m);
		   
	   void insertManager(Manager m);

}
