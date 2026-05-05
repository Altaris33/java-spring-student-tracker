package fr.captain.student_tracker.service;

import fr.captain.student_tracker.dao.StudentDAO;
import fr.captain.student_tracker.dto.StudentRequest;
import fr.captain.student_tracker.dto.StudentResponse;
import fr.captain.student_tracker.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Student> getStudents() {
        return this.studentDAO.findAll();
    }

    @Transactional
    public StudentResponse createStudent(StudentRequest request) {
        Student studentToSave = mapToStudent(request);
        Student saved = this.studentDAO.save(studentToSave);
        return mapToResponse(saved);
    }

    private StudentResponse mapToResponse(Student studentToSave) {
        return new StudentResponse(
                studentToSave.getId(),
                studentToSave.getFirstName(),
                studentToSave.getLastName(),
                studentToSave.getEmail()
        );
    }

    private Student mapToStudent(StudentRequest request) {
        return new Student(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail()
        );
    }
}
