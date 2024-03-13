package com.spring.cruddemo.dao;

import com.spring.cruddemo.Entity.Student;

public interface StudentDAO {
    public void save(Student student);

    Student findById(Integer id);


}
