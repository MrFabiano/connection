package com.redis.connection.model;

import java.util.Map;

public interface StudentDAO {


    void saveStudent(Student student);
    Student getOneStudent(Integer id);
    void updateStudent(Student student);
    Map<Integer, Student> getAllStudents();
    void deleteStudent(Integer id);
    void saveAllStudents(Map<Integer, Student> map);
}
