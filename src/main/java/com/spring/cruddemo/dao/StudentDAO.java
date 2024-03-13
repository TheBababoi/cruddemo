package com.spring.cruddemo.dao;

import com.spring.cruddemo.Entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);


}
