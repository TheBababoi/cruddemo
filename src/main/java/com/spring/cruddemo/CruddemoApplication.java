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
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting total students : " + studentDAO.deleteAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id
		int studentId = 2;
		System.out.println("Gerring student with id : " + studentId);
		Student student = studentDAO.findById(studentId);

		//change first name
		System.out.println("Updating student...");
		student.setFirstName("Diego");

		//update the student
		studentDAO.update(student);

		//display the updated student
		System.out.println("Updated student: "  + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> students = studentDAO.findByLastName("Black");

		//display list of students
		for(Student student : students){
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> students = studentDAO.findAll();

		//display list of students
		for(Student student : students){
			System.out.println(student);
		}
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
