package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;



public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// Create a session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session

		Session session = factory.getCurrentSession();
		
		try {
								
			// Start a transaction 
			session.beginTransaction();
			
			// Query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// Display students
			displayStudents(theStudents);
			
			// Query Students: lastName:'Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Safronov'").list();
			
			// Query Students: lastName:'Doe' OR firstName:'Billy'
						theStudents = session.createQuery("from Student s where s.firstName='Billy'").list();
						
			// Display the students
			System.out.println("\n\nStudents who has the last name of Safronov OR first name Billy");
			displayStudents(theStudents);
			
			// Display the students
			System.out.println("\n\nStudents who has the last name of Safronov");
			displayStudents(theStudents);
			
			// Query students where email LIKE '%mail.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%mail.com'").list();
			
			System.out.println("\n\nStudents who email ends with mail.com");
			
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
