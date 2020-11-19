package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			
			// start a transaction
			session.beginTransaction();
		
			// Get the instructor from db
				int theId = 1;
				Instructor tempInstructor = session.get(Instructor.class, theId);

			// Create some courses
			Course tempCourse01 = new Course("Learn anything...");
			Course tempCourse02 = new Course("Learn More anything...");

			// Add courses to instructor
			tempInstructor.add(tempCourse01);
			tempInstructor.add(tempCourse02);

			// Save the courses
			session.save(tempCourse01);
			session.save(tempCourse02);


			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {

			// Add clean up code
			session.close();
			
			factory.close();
		}
	}

}





