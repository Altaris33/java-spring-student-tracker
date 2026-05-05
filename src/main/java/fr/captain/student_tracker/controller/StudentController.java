package fr.captain.student_tracker.controller;

import fr.captain.student_tracker.dto.StudentRequest;
import fr.captain.student_tracker.dto.StudentResponse;
import fr.captain.student_tracker.entity.Student;
import fr.captain.student_tracker.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentRequest request) {
        StudentResponse created = this.studentService.createStudent(request);
        return ResponseEntity.created(URI.create("students/" + created.getId()))
                .body(created);
    }
}
