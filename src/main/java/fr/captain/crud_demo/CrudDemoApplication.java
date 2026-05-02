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
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student object");
		Student studentToCreate = new Student("Paul", "Atreides", "paul.atreides@gmail.com");

		System.out.println("Saving the student to the DB");
		studentDAO.save(studentToCreate);

		System.out.println("ID of saved student: " + studentToCreate.getId());
	}

}
