package com.keval.SpringHibernateApp.dao;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import com.keval.SpringHibernateApp.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
	Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	public List<Employee> getEmployees() {
		Session session = sessionFactory.openSession();
		Query q  = session.createQuery("from Employee");
		List<Employee> employeeList = q.getResultList();
		session.close();
		return employeeList;
	}

	public Employee getEmployee(int employeeId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class,employeeId);
		session.getTransaction().commit();
		session.close();
		return employee;
	}
	
	public void addEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteEmployee(int employeeId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class,employeeId);
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
	}

	public void updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(employee);
		session.getTransaction().commit();
		session.close();
	}
}
