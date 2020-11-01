package com.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;
import com.hibernate.utils.DateUtils;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create 3 Student object
			System.out.println("Creating 3 Student object...");
			Student tempStudent1 = new Student("John", "Doe", "john@testcode.com", DateUtils.parseDate("10/04/1987"));
			Student tempStudent2 = new Student("Mary", "Public", "mary@testcode.com", DateUtils.parseDate("30/09/1982"));
			Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@testcode.com", DateUtils.parseDate("05/07/1992"));
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
}
