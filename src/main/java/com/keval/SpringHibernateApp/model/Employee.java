package com.keval.SpringHibernateApp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeId;
	private String name;
	private int age;
	private float salary;
	private String joiningDate;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="employee",cascade = CascadeType.ALL)
	private List<Skill> Skill;
	
	@Transient
	private List<String> skillList;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	public List<Skill> getSkill() {
		return Skill;
	}
	public void setSkill(List<Skill> skill) {
		Skill = skill;
	}
	
	public List<String> getSkillList() {
		return skillList;
	}
	public void setSkillList(List<String> skillList) {
		this.skillList = skillList;
	}
}
