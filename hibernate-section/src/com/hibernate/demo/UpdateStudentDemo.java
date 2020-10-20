package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// Create a session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session

		Session session = factory.getCurrentSession();
		
		try {
		
			int studentId = 1;
	
			// Now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			// Delete the student
			//System.out.println("Deleting student: " + myStudent);
			//session.delete(myStudent);
			
			// Delete the student id=2 using hql
			System.out.println("Deleting student id=2");
			
			session.createQuery("delete from Student where id=2").executeUpdate();
	
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			
			factory.close();
		}
	}

}
