package com.my.circuitbreaker.circuitbreakerapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class StudentServiceController {

    Logger slf4jLogger = LoggerFactory.getLogger(this.getClass()); // OR
    //Logger slf4jLogger2 = LoggerFactory.getLogger(StudentServiceController.class);


    private static Map<String, List<Student>> schoolDatabase  = new HashMap<String, List<Student>>();

    private static Student dummyStudent = new Student("Not Found", "N/A");

    static {

        List<Student> studentsList = new ArrayList<>();

        Student std1 = new Student("Sajal", "FirstClass");
        Student std2 = new Student("Kunal", "SecondClass");
        Student std3 = new Student("Tingru", "FirstClass");

        studentsList.add(std1);
        studentsList.add(std2);
        studentsList.add(std3);

        schoolDatabase.put("School1", studentsList);

        studentsList = new ArrayList<>();

        Student std4 = new Student("Sajal", "FirstClass");
        Student std5 = new Student("Swati", "SecondClass");
        Student std6 = new Student("Kushboo", "ThirdClass");

        studentsList.add(std4);
        studentsList.add(std5);
        studentsList.add(std6);

        schoolDatabase.put("School2", studentsList);

    }

    @GetMapping("/getStudentsBySchoolName/{schoolName}")
    public List<Student> getStudentsList(@PathVariable String schoolName) {

        if(schoolName == null || schoolName.isEmpty())
            throw new RuntimeException("Invalid school name parameter provided!");

        slf4jLogger.info("Getting students list for school: {}", schoolName);
        System.out.println("Getting students list for school: " + schoolName);

        List<Student> students = schoolDatabase.get(schoolName);

        if(students == null) {
            students = new ArrayList();
            students.add(dummyStudent);
        }
        return students;

    }
}
