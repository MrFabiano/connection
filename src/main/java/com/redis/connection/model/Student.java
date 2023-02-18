package com.redis.connection.model;

import com.redis.connection.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = -7817224776021728682L;

    private Integer id;
    private String name;
    private int age;
    private Gender gender;


}
