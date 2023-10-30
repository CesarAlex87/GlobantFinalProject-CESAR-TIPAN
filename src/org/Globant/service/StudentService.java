package org.Globant.service;

import org.Globant.domain.Student;
import org.Globant.dto.AddStudentDto;
import org.Globant.dto.StudentDto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentService implements IStudentService{
    private final List<Student> students = new ArrayList<>();
    private int currentStudentId = 100001;
    private int currentId = 1;

    public StudentService() {
        initStudents();
    }

    private int getNextStudentId() {
        return currentStudentId++;
    }

    private int getNextCurrentId(){ return currentId++; }

    @Override
    public StudentDto addStudent(AddStudentDto addStudentDto) {
        var student = new Student(this.getNextCurrentId(), this.getNextStudentId(), addStudentDto.getName(), addStudentDto.getAge());
        students.add(student);

        return new StudentDto(student.getStudentId(), student.getName(), student.getAge());
    }

    @Override
    public StudentDto getStudentByStudentId(int studentId) {
        Student student = students.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst()
                .orElse(null);

        if (student != null) {
            return new StudentDto(student.getStudentId(), student.getName(), student.getStudentId());
        } else {
            throw new NoSuchElementException("Student doesn't exist or not found: " + studentId );
        }
    }

    @Override
    public List<StudentDto> getStudents() {
        return students.stream()
                .map(student -> new StudentDto(student.getStudentId(), student.getName(), student.getAge()))
                .toList();
    }

    @Override
    public StudentDto updateStudent(int id, AddStudentDto addStudentDto) {
        return null;
    }

    private void initStudents() {
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Carlos Alberto Gómez", 21));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Luisa Fernanda Vargas", 23));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Javier Alejandro Ramírez", 19));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Ana María Torres", 27));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Roberto Carlos López", 22));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Daniela González", 24));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Miguel Ángel Fernández", 28));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Elena Martínez", 20));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "José Luis Pérez", 26));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Sofía Ramírez", 25));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Diego Sánchez", 21));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Valentina Gómez", 22));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Carlos López", 23));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Isabel Vargas", 24));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Luis Martínez", 25));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "María González", 26));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Pablo Rodríguez", 27));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Lorena Sánchez", 28));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Andrea López", 29));
        students.add(new Student(getNextCurrentId(), getNextStudentId(), "Ricardo Pérez", 30));
    }

}
