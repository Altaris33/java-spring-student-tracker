package fr.captain.crud_demo.dao;

import fr.captain.crud_demo.entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);
}
