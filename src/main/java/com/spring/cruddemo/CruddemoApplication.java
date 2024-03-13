package com.spring.cruddemo;

import com.spring.cruddemo.Entity.Student;
import com.spring.cruddemo.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLOutput;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creatingnew student obj");
		Student tempStudent = new Student("John","Jony","jony@gmail.com");
		studentDAO.save(tempStudent);
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
		Student student = studentDAO.findById(tempStudent.getId());
		System.out.println(student);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating 3 new student objs");
		Student tempStudent1 = new Student("Alfred","Black","alfredblack@gmail.com");
		Student tempStudent2 = new Student("Jake","Jones","jakejones@gmail.com");
		Student tempStudent3 = new Student("Nick","White","nickwhite@gmail.com");

		//save the student object
		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved student. Generated id: " + tempStudent3.getId());
	}


	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating a new student obj");
		Student tempStudent = new Student("Mike","Jones","mikejones@gmail.com");

		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());


	}

}
