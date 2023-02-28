package com.keval.SpringHibernateApp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keval.SpringHibernateApp.dao.EmployeeDao;
import com.keval.SpringHibernateApp.model.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDaoImpl;
	
	public Employee fetchData(int employeeId) {
		Employee employee = employeeDaoImpl.getEmployee(employeeId);
        return employee;
	}

	public void deleteEmployee(int employeeId) {
		employeeDaoImpl.deleteEmployee(employeeId);
		return ; 
	}

	public List<Employee> viewEmployee() {
		List<Employee> employeeList = employeeDaoImpl.getEmployees();
	    return employeeList;
	}

	public void createEmployee(Employee employee) {
		employeeDaoImpl.addEmployee(employee);
		return;	
	}

	public void updateEmployee(Employee employee) {
		employeeDaoImpl.updateEmployee(employee);
		return;
	}
}
