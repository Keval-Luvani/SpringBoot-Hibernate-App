package com.keval.SpringHibernateApp.dao;

import java.util.List;

public interface SkillDao {
	public List<String> getSkills(int employeeId);
	public void deleteSkill(List<String> deleteSkillList,int employeeId);
}
