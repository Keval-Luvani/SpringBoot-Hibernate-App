package com.keval.SpringHibernateApp.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SkillDaoImpl implements SkillDao {
	Configuration configuration = new Configuration().configure();
	SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	public List<String> getSkills(int employeeId){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query q  = session.createQuery("select skill from Skill  where employee="+employeeId);
		List<String> skillList = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return skillList;
	}
	
	public void deleteSkill(List<String> deleteSkillList,int employeeId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for(String skill : deleteSkillList) {
			Query q  = session.createQuery("delete from Skill  where employee="+employeeId+" and skill='"+skill+"'");
			q.executeUpdate();
		}
		session.getTransaction().commit();
		session.close();
	}
}
