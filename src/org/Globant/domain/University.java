package org.Globant.domain;

import java.util.ArrayList;

public class University {
    private ArrayList<Teacher> teachersLst;
    private ArrayList<Student> studentsLst;
    private ArrayList<Classroom> classroomsLst;

    public ArrayList<Teacher> getTeachersLst() {
        return teachersLst;
    }

    public void setTeachersLst(ArrayList<Teacher> teachersLst) {
        this.teachersLst = teachersLst;
    }

    public ArrayList<Student> getStudentsLst() {
        return studentsLst;
    }

    public void setStudentsLst(ArrayList<Student> studentsLst) {
        this.studentsLst = studentsLst;
    }

    public ArrayList<Classroom> getClassroomsLst() {
        return classroomsLst;
    }

    public void setClassroomsLst(ArrayList<Classroom> classroomsLst) {
        this.classroomsLst = classroomsLst;
    }
}
