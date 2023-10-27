package org.Globant.service;

import org.Globant.domain.Classroom;
import org.Globant.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ClassroomService implements IClassroomService{
    private final List<Classroom> classrooms = new ArrayList<>();

    public ClassroomService() {
        classrooms.add(new Classroom("CALCULO INTEGRAL", "101", new ArrayList<StudentDto>(), new TeacherDto()));
        classrooms.add(new Classroom("POO", "102", new ArrayList<StudentDto>(), new TeacherDto()));
        classrooms.add(new Classroom("ESTADISTICA", "103", new ArrayList<StudentDto>(), new TeacherDto()));
        classrooms.add(new Classroom("BASE DE DATOS", "104", new ArrayList<StudentDto>(), new TeacherDto()));
    }

    @Override
    public List<ClassroomDto> getAllClassroomsByStudent(StudentDto studentSearched) {
        List<ClassroomDto> classroomsWithStudent = new ArrayList<>();

        for (Classroom classroom : classrooms) {
            ArrayList<StudentDto> classStudents = classroom.getClassStudents();
            if (classStudents.stream().anyMatch(student -> student.equals(studentSearched))) {
                ClassroomDto classroomDto = new ClassroomDto(classroom.getName(), classroom.getClassNumber(), classStudents, classroom.getTeacher());
                classroomsWithStudent.add(classroomDto);
            }
        }

        return classroomsWithStudent;
    }


    @Override
    public void addStudentToClassroom(StudentDto studentToAdd, String classNumber) {
        if (studentToAdd != null) {
            Classroom classroom = findClassroomByClassNumber(classNumber);

            if (classroom != null) {
                ArrayList<StudentDto> classStudents = classroom.getClassStudents();
                classStudents.add(studentToAdd);
                classroom.setClassStudents(classStudents);
                System.out.println("STUDENT: " + studentToAdd + ", added succesfully to CLASSROOM: " + classNumber);
            } else {
                throw new NoSuchElementException("Classroom not found or doesn't exist: " + classNumber);
            }
        } else {
            throw new NoSuchElementException("Student doesn't exist or not found: " + studentToAdd);
        }
    }

    private Classroom findClassroomByClassNumber(String classNumber) {
        return classrooms.stream()
                .filter(classroom -> classroom.getClassNumber().equals(classNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public ClassroomDto addClassroom(AddClassroomDto addClassroomDto) {
        var classroom = new Classroom(addClassroomDto.getName(), addClassroomDto.getClassNumber(), addClassroomDto.getClassStudents(), addClassroomDto.getTeacher());
        classrooms.add(classroom);

        return new ClassroomDto(classroom.getName(), classroom.getClassNumber(), classroom.getClassStudents(), classroom.getTeacher());
    }


    @Override
    public ClassroomDto getClassroom(String classNumber) {
        Classroom classroom = findClassroomByClassNumber(classNumber);
        if (classroom != null) {
            return new ClassroomDto(classroom.getName(), classroom.getClassNumber(), classroom.getClassStudents(), classroom.getTeacher());
        } else {
            throw new NoSuchElementException("Classroom not found or doesn't exist: " + classNumber);
        }
    }

    @Override
    public List<ClassroomDto> getClassrooms() {
        return classrooms.stream()
                .map(classroom -> new ClassroomDto(classroom.getName(), classroom.getClassNumber(), classroom.getClassStudents(), classroom.getTeacher()))
                .toList();
    }

    @Override
    public ClassroomDto updateClassroom(String classNumber, AddClassroomDto addClassroomDto) {
        Classroom classroom = findClassroomByClassNumber(classNumber);

        if (classroom != null) {
            classroom.setName(addClassroomDto.getName());
            classroom.setClassNumber(addClassroomDto.getClassNumber());
            classroom.setClassStudents(addClassroomDto.getClassStudents());
            classroom.setTeacher(addClassroomDto.getTeacher());

            return new ClassroomDto(classroom.getName(), classroom.getClassNumber(), classroom.getClassStudents(), classroom.getTeacher());
        } else {
            throw new NoSuchElementException("Classroom not found or doesn't exist: " + classNumber);
        }
    }
}
