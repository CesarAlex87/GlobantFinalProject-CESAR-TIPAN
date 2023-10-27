package org.Globant.service;

import org.Globant.domain.Student;
import org.Globant.dto.AddStudentDto;
import org.Globant.dto.StudentDto;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService{
    private final List<Student> students = new ArrayList<>();
    private int currentStudentId = 100001;
    private int id = 1;

    public StudentService() {
        students.add(new Student(getNextStudentId(), "Juan Carlos Pérez", 28));
        students.add(new Student(getNextStudentId(), "María Isabel Rodríguez", 22));
        students.add(new Student(getNextStudentId(), "Pedro Luis Martínez", 24));
        students.add(new Student(getNextStudentId(), "Laura Elena Sánchez", 20));
        students.add(new Student(getNextStudentId(), "Andrés Antonio González", 26));
        students.add(new Student(getNextStudentId(), "Carmen Rosa López", 25));
    }

    private int getNextStudentId() {
        return currentStudentId++;
    }

    private int getNextId() { return id++; }

    @Override
    public StudentDto addStudent(AddStudentDto addStudentDto) {
        var student = new Student(this.getNextStudentId(), addStudentDto.getName(), addStudentDto.getAge());
        students.add(student);

        return new StudentDto(1, student.getStudentId(), student.getName(), student.getAge());
    }

    @Override
    public StudentDto getStudent(int id) {
        return null;
    }

    @Override
    public List<StudentDto> getStudents() {
        return students.stream()
                .map(student -> new StudentDto(1, student.getStudentId(), student.getName(), student.getAge()))
                .toList();
    }

    @Override
    public StudentDto updateStudent(int id, AddStudentDto addStudentDto) {
        return null;
    }
}
