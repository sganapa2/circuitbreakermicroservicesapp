package com.my.circuitbreaker.circuitbreakerapp;


public class Student {
    private String studentName;
    private String classStandard;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassStandard() {
        return classStandard;
    }

    public void setClassStandard(String classStandard) {
        this.classStandard = classStandard;
    }

    public Student(String studentName, String classStandard) {
        this.studentName = studentName;
        this.classStandard = classStandard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", classStandard='" + classStandard + '\'' +
                '}';
    }
}
