package com.keval.SpringHibernateApp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keval.SpringHibernateApp.dao.EmployeeDao;
import com.keval.SpringHibernateApp.model.Employee;
import com.keval.SpringHibernateApp.model.Skill;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDaoImpl;
	@Autowired
	SkillService skillServiceImpl;
	
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
		List<Skill> skillList = new ArrayList<>();
		for(String skill: employee.getSkillList()) {
			Skill tempSkill = new Skill();
			tempSkill.setEmployee(employee);
			tempSkill.setSkill(skill);
			skillList.add(tempSkill);
		}
		employee.setSkill(skillList);
		employeeDaoImpl.addEmployee(employee);
		return;	
	}

	public void updateEmployee(Employee employee) {
		List<Skill> addSkillList = skillServiceImpl.updateSKill(employee);
		employee.setSkill(addSkillList);
		employeeDaoImpl.updateEmployee(employee);
		return;
	}
}
