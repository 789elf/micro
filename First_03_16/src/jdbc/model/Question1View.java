package jdbc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Question1View extends Employee{

	public Question1View(String first_name, int department_id, String department_name,String city){
		setFirst_name(first_name);
		setDepartment(new Department());
		getDepartment().setDepartment_id(department_id);
		getDepartment().setDepartment_name(department_name);
		
	}
	
	

}