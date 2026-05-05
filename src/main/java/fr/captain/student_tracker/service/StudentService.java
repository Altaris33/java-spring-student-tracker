package fr.captain.student_tracker.service;

import fr.captain.student_tracker.dao.StudentDAO;
import fr.captain.student_tracker.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
