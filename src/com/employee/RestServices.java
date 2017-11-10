package com.employee;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.employee.dao.EmployeeDAO;
import com.google.gson.Gson;

/**
 * 
 * @author Murthy
 *
 */
@Path("/EmployeeServices")
public class RestServices {

	/**
	 * Get Service Which will call from AngularJS to Fetch 
	 * all employees from the Employee Table.
	 *  
	 * @return
	 */
	@GET
	@Path("/GetEmployees")
	@Produces("application/json")
	public String getEmployee() {
		EmployeeDAO dao = new EmployeeDAO();
		String employees = null;
		List employeeList = dao.getEmployees();
		Gson gson = new Gson();
		System.out.println(gson.toJson(employeeList));
		employees = gson.toJson(employeeList);
		return employees;
	} 
	
	
	/**
	 * Create Service Which will call from AngularJS to create
	 * new employee.
	 *  
	 * @param emp
	 * @return
	 */
	@POST
	@Path("/create")
	@Consumes("application/json")
	public Response addEmployee( EmployeeBean emp) {
		
		System.out.println("Employee Bean create"+emp);
		System.out.println("Employee Bean create"+emp.getName());
		emp.setName(emp.getName());
		emp.setAge(emp.getAge());
 
		EmployeeDAO dao = new EmployeeDAO();
		dao.addEmployee(emp);
  
		return Response.ok().build();
	}
	
	/**
	 * Update Service Which will call from AngularJS to Update
	 * existing employee.
	 * 
	 * @param emp
	 * @return
	 */
	@PUT
	@Path("/update")
	@Consumes("application/json")
	public Response updateEmployee( EmployeeBean emp) {
		
		System.out.println("Employee Bean Update "+emp);
		System.out.println("Employee Bean Update "+emp.getName());
		emp.setName(emp.getName());
		emp.setAge(emp.getAge());
 
		EmployeeDAO dao = new EmployeeDAO();
		dao.updateEmployee(emp);
  
		return Response.ok().build();
	}
	
	
	/**
	 * Delete Service Which will call from AngularJS to Delete
	 * existing employee.
	 * 
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/deleteEmployee/{id}")
	@Consumes({"application/json",MediaType.TEXT_PLAIN})
	public Response deleteEmployee(@PathParam("id") int id) {
		
		System.out.println("id ****************"+id);
		EmployeeDAO dao = new EmployeeDAO();
		int count = dao.deleteEmployee(id);
		if (count == 0) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}
}