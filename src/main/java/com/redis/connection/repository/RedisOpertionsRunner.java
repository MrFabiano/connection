package com.redis.connection.repository;

import com.redis.connection.enums.Gender;
import com.redis.connection.model.Student;
import com.redis.connection.model.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RedisOpertionsRunner implements CommandLineRunner {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public void run(String... args) throws Exception {

            //saving one student
        studentDAO.saveStudent(new Student(500, "Jane", 21, Gender.FEMALE));

            //saving multiple students
        studentDAO.saveAllStudents(
                    Map.of( 501, new Student(501, "Juliana", 18, Gender.FEMALE),
                            502, new Student(502, "Paula", 27, Gender.FEMALE),
                            503, new Student(503, "Fernanda", 31, Gender.FEMALE)
                    )
            );

            //modifying student with empId 503
        studentDAO.updateStudent(new Student(503, "Daiane", 33, Gender.FEMALE));

            //deleting student with empID 500
        studentDAO.deleteStudent(500);

            //retrieving all students
        studentDAO.getAllStudents().forEach((k, v)-> System.out.println(k +" : "+v));

            //retrieving student with empID 501
            System.out.println("Emp details for 501 : "+studentDAO.getOneStudent(501));
        }
    }
