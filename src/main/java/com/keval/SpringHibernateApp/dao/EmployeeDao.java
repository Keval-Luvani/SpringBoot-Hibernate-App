package com.keval.SpringHibernateApp.dao;

import java.util.List;
import com.keval.SpringHibernateApp.model.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployees();
	public Employee getEmployee(int id);
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(int id);
}
