package org.Globant.dto;

public class StudentDto {
    private int id;
    private int studentId;
    private String name;
    private int age;

    public StudentDto(){}

    public StudentDto(int id, int studentId, String name, int age) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "NAME: " + name + ", AGE: " + age;
    }
}
