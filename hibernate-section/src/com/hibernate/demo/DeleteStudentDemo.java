package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			System.out.println("Updating student... ");
			myStudent.setFirstName("McCartney");
			
			// Commit transaction
			session.getTransaction().commit();
			
			// New Code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Update email for all students
			System.out.println("Updating email for all students... ");
			
			session.createQuery("update Student set email='foo@mail.com'").executeUpdate();
			
			// Commit transaction
			session.getTransaction().commit();
			
		} finally {
			
			factory.close();
		}
	}

}
