package com.keval.SpringHibernateApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keval.SpringHibernateApp.dao.SkillDao;
import com.keval.SpringHibernateApp.model.Employee;
import com.keval.SpringHibernateApp.model.Skill;

@Component
public class SkillServiceImpl implements SkillService {
	
	@Autowired
	SkillDao skillDaoImpl;
	
	public List<Skill> updateSKill(Employee employee) {
		List<Skill> addSkillList = new ArrayList<>();
		List<String> deleteSkillList =  new ArrayList<>();
		List<String> databaseSkillList = skillDaoImpl.getSkills(employee.getEmployeeId());
		List<String> updatedSkillList = employee.getSkillList();  
		
		for(String skill : updatedSkillList) {
			if(!databaseSkillList.contains(skill)){
				Skill tempSkill = new Skill();
				tempSkill.setEmployee(employee);
				tempSkill.setSkill(skill);
				addSkillList.add(tempSkill);
			}
		}
		
		for(String skill : databaseSkillList) {
			if(!updatedSkillList.contains(skill)){
				deleteSkillList.add(skill);
			}
		}
		skillDaoImpl.deleteSkill(deleteSkillList, employee.getEmployeeId());
		return addSkillList;
	}
}
