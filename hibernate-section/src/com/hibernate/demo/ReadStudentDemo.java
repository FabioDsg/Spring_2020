package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// Create a session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session

		Session session = factory.getCurrentSession();
		
		try {
			
			
			// Create a student object
			System.out.println("Creating a new student object");
			Student tempStudent = new Student("Roy", "Duck", "roy@mail.com");
	
			// Start a transaction 
			session.beginTransaction();
			
			// Save the student object 
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// ** NEW CODE Below **
			
			// Find out the student's id: primary key
			System.out.println("Saved student. Genarated id: " + tempStudent.getId());
			System.out.println("Done!");
			
			// Now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve based on the id: primary key
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			// Commit transaction
			session.getTransaction().commit();
			
			
		} finally {
			
			factory.close();
		}
	}

}
