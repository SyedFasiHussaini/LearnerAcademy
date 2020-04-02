package com.learner_academy.DAO.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.learner_academy.DAO.StudentDAO;
import com.learner_academy.model.Student;

public class StudentDAOImpl implements StudentDAO {

	Configuration configuration = new Configuration().configure();
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
	
	public Student createStudent(Student student) {
		Session session =factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();
		return student;	
	}
	
	public Student getStudentById(int studentId) {
		Session session =factory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student=(Student)session.get(Student.class, studentId);
//		Student student=(Student)session.createQuery("select studentId from com.learner_academy.model.Student s where s.studentId=:studentIdParam").setParameter("studentIdParam", studentId);
		transaction.commit();
		session.close();
		return student;
	}


	public List<Student> getAllStudents() {
		Session session =factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Student> studentList=session.createQuery("from com.learner_academy.model.Student").list();
		transaction.commit();
		session.close();
		return studentList;
	}

	
	public Student updateStudent(Student student) {
		Session session =factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(student);
		transaction.commit();
		session.close();
		return student;
	}
	
//	public void removeStudent(int studentId) {
//		Session session =factory.openSession();
//		Transaction transaction = session.beginTransaction();
//		Student stu= new Student();
//		stu.setStudentId(studentId);
//		session.delete(stu);
//		transaction.commit();
//		session.close();
//				
//	}

}
