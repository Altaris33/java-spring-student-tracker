package fr.captain.crud_demo;

import fr.captain.crud_demo.dao.StudentDAO;
import fr.captain.crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		students.forEach(System.out::println);
		System.out.println("Deleting all students");
		int deletedStudents = studentDAO.deleteAll();
		System.out.println("Number of students deleted: " + deletedStudents);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 3;
		System.out.println("Deleting student with id: " + id);
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 1;
		System.out.println("Getting student with id: " + id);
		Student student = studentDAO.findById(id);

		System.out.println("Updating student" + student);
		student.setFirstName("Yoshi");
		studentDAO.update(student);

		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		String lastName = "Falcon";
		List<Student> students = studentDAO.findByLastName(lastName);
		for (Student student: students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating student object");
		Student student = new Student("Zelda", "Zelda", "zelda.zelda@gmail.com");

		System.out.println("Saving student: " + student);
		studentDAO.save(student);
		int id = student.getId();
		System.out.println("ID of saved student: " + id);

		System.out.println("Retrieving the student: " + id);
		Student foundStudent = studentDAO.findById(id);
		System.out.println("Found student: " + foundStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for (Student student: students) {
			System.out.println(student);
		}
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student object");
		Student studentToCreate = new Student("Paul", "Atreides", "paul.atreides@gmail.com");

		System.out.println("Saving the student to the DB");
		studentDAO.save(studentToCreate);

		System.out.println("ID of saved student: " + studentToCreate.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating student objects");
		Student student1 = new Student("Paul", "Doe", "paul.doe@gmail.com");
		Student student2 = new Student("Captain", "Falcon", "captain.falcon@gmail.com");
		Student student3 = new Student("Ganon", "Ouhh", "ganon.ouhh@gmail.com");

		System.out.println("Saving the students to the DB");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		System.out.println("ID of saved student: " + student1.getId());
		System.out.println("ID of saved student: " + student2.getId());
		System.out.println("ID of saved student: " + student3.getId());
	}

}
