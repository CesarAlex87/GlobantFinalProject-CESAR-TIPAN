package org.Globant.domain;
import org.Globant.dto.StudentDto;
import org.Globant.dto.TeacherDto;

import java.util.ArrayList;

public class Classroom {
    private String name;
    private String classNumber;
    private ArrayList<StudentDto> classStudents;
    private TeacherDto teacher;


    public Classroom(String name, String classNumber, ArrayList<StudentDto> classStudents, TeacherDto teacher) {
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

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public ArrayList<StudentDto> getClassStudents() {
        return classStudents;
    }

    public void setClassStudents(ArrayList<StudentDto> classStudents) {
        this.classStudents = classStudents;
    }

    public TeacherDto getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDto teacher) {
        this.teacher = teacher;
    }
}
