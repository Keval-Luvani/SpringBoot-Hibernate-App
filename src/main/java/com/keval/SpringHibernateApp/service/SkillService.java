package com.keval.SpringHibernateApp.service;

import java.util.List;

import com.keval.SpringHibernateApp.model.Employee;
import com.keval.SpringHibernateApp.model.Skill;

public interface SkillService {
	public List<Skill> updateSKill(Employee employee);
}
