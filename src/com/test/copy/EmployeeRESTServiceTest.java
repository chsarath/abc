package com.test.copy;

import java.util.List;

import com.employee.dao.Employee;
import com.employee.dao.EmployeeDAO;



public class EmployeeRESTServiceTest {

	public static void main(String[] args) {
		
		EmployeeDAO personDAO=new EmployeeDAO();
		
		List<Employee> queryList = personDAO.getEmployees();
		
        if (queryList != null && queryList.isEmpty()) {
        	
        	 System.out.println("Query is empty");
        	 
        } else {
            System.out.println("list " + queryList.size());
        	Employee p=(Employee) queryList;
        	System.out.println("Employee Objects--"+p);
       
           
        }	       
		
	}
}