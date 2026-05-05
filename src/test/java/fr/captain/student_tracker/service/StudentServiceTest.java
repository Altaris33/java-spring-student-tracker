package fr.captain.student_tracker.service;

import fr.captain.student_tracker.dao.StudentDAO;
import fr.captain.student_tracker.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class StudentServiceTest {

    private StudentDAO studentDAO;
    private StudentService service;

    @BeforeEach
    void setUp() {
        studentDAO = Mockito.mock(StudentDAO.class);
        service = new StudentService(studentDAO);
    }

    @Test
    public void shouldGetStudents() {
        List<Student> students = new ArrayList<>();
        Student alice = new Student("Alice", "Smith", "alice.smith@test.com");
        Student bob = new Student("Bob", "Smith", "bob.smith@test.com");
        alice.setId(1);
        bob.setId(2);
        students.add(alice);
        students.add(bob);

        when(studentDAO.findAll()).thenReturn(students);

        var response = service.getStudents();

        assertEquals(2, students.size());
        assertNotNull(response);
    }
}
