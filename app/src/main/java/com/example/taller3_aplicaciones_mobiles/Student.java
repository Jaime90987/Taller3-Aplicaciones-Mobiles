package com.example.taller3_aplicaciones_mobiles;

import java.io.Serializable;

public class Student implements Serializable {
    private String student_code;
    private String email;

    Student(String student_code, String email) {
        this.student_code = student_code;
        this.email = email;
    }

    public String getStudent_code() {
        return student_code;
    }

    public String getEmail() {
        return email;
    }
}
