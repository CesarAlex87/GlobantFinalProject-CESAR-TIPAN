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

    @Override
    public StudentDto addStudent(AddStudentDto addStudentDto) {
        var student = new Student(this.getNextStudentId(), addStudentDto.getName(), addStudentDto.getAge());
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
}
