package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// Create a session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				// create session

				Session session = factory.getCurrentSession();
				
				try {
					
					
					// Create 3 students objects
					System.out.println("Creating a new student object");
					Student tempStudent1 = new Student("Billy", "Wall", "billy@mail.com");
					Student tempStudent2 = new Student("Johan", "Gielen", "Johan@mail.com");
					Student tempStudent3 = new Student("Georgie", "Safronov", "Georgie@mail.com");
					
					// Start a transaction 
					session.beginTransaction();
					
					// Save the student object 
					System.out.println("Saving the students...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
					
				} finally {
					
					factory.close();
				}

	}

}
