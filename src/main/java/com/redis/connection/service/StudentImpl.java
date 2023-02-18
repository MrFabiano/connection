package com.redis.connection.service;

import com.redis.connection.model.Student;
import com.redis.connection.model.StudentDAO;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class StudentImpl implements StudentDAO {

    private final String hashReference= "Student";


    @Resource(name="redisTemplate")// 'redisTemplate' is defined as a Bean in AppConfig.java
    private HashOperations<String, Integer, Student> hashOperations;

    @Override
    public void saveStudent(Student student) {
        hashOperations.putIfAbsent(hashReference, student.getId(), student);
    }

    @Override
    public Student getOneStudent(Integer id) {
        return hashOperations.get(hashReference, id);
    }

    @Override
    public void updateStudent(Student student) {
        hashOperations.put(hashReference, student.getId(), student);
    }

    @Override
    public Map<Integer, Student> getAllStudents() {
        return hashOperations.entries(hashReference);
    }

    @Override
    public void deleteStudent(Integer id) {
        hashOperations.delete(hashReference, id);
    }

    @Override
    public void saveAllStudents(Map<Integer, Student> map) {
        hashOperations.putAll(hashReference, map);
    }
}
