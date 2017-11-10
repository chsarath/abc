package com.employee.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.employee.EmployeeBean;

public class EmployeeDAO {

	/**
	 * Add Employee Operation. To Describe "CREATE" operations.
	 * @param bean
	 */
	public void addEmployee(EmployeeBean bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addEmployee(session, bean);
		tx.commit();
		session.close();

	}

	/**
	 * Update Employee Operation. To Describe "UPDATE" operations.
	 *  
	 * @param bean
	 */
	public void updateEmployee(EmployeeBean bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		updateEmployee(session, bean);
		tx.commit();
		session.close();

	}


	/**
	 * To Get All Employee. To Describe "GET" operations.
	 * 
	 * @return
	 */
	public List getEmployees() {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Employee");
		List employees = query.list();
		return employees;
	}


	/**
	 * To Delete Employee. To Describe "DELETE" operations.
	 * 
	 * @param id
	 * @return
	 */
	public int deleteEmployee(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from Employee where id = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
	
	
	/**
	 * Private method to add Employee
	 * 
	 * @param session
	 * @param bean
	 */
	private void addEmployee(Session session, EmployeeBean bean) {
		Employee employee = new Employee();

		employee.setName(bean.getName());
		employee.setAge(bean.getAge());

		session.save(employee);
	}

	/**
	 * 
	 * Private method to update Employee
	 * 
	 * @param session
	 * @param bean
	 */
	
	private void updateEmployee(Session session, EmployeeBean bean) {
		Employee employee = new Employee();
		employee.setId(bean.getId());
		employee.setName(bean.getName());
		employee.setAge(bean.getAge());

		session.update(employee);
	}

}