package org.Globant.domain;

public class Student extends Person{
    private int studentId;
    private int age;

    public Student(int studentId, String name, int age) {
        super(name);
        this.studentId = studentId;
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
