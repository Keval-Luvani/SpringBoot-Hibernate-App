package com.keval.SpringHibernateApp.service;

import java.util.List;

import com.keval.SpringHibernateApp.model.Employee;

public interface EmployeeService {
	Employee fetchData(int employeeId);
	void deleteEmployee(int employeeId);
	List<Employee> viewEmployee();
	void createEmployee(Employee employee);
	void updateEmployee(Employee employee);
}
