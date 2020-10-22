package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			//Student tempStudent = new Student("Jonh", "Doe", "doe@mail.com");
			
			Student Student2 = new Student("Paul", "Sarakov", "sarakov@mail.com");
			
			// Start a transaction 
			session.beginTransaction();
			
			// Save the student object 
			System.out.println("Saving the student...");
			session.save(Student2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			
			factory.close();
		}
	}

}
