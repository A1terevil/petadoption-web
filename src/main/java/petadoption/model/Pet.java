package petadoption.model;

import lombok.Data;

@Data
public class Pet {
	private Integer pid;
	private String pname;
	private String species;
	private String psex;
	private String birthday;
	private String condition;
	private String image;
	
}
