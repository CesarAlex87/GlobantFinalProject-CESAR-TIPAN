package org.Globant.domain;
import java.util.ArrayList;

public class Classroom {
    private String name;
    private int classNumber;
    private ArrayList<Student> classStudents;
    private Teacher teacher;

    public Classroom(String name, int classNumber, ArrayList<Student> classStudents, Teacher teacher) {
        this.name = name;
        this.classNumber = classNumber;
        this.classStudents = classStudents;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public ArrayList<Student> getClassStudents() {
        return classStudents;
    }

    public void setClassStudents(ArrayList<Student> classStudents) {
        this.classStudents = classStudents;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
