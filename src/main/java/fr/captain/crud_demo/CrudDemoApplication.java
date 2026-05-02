package fr.captain.crud_demo;

import fr.captain.crud_demo.dao.StudentDAO;
import fr.captain.crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
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
