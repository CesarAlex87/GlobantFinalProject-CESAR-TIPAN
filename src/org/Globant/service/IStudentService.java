package org.Globant.service;

import org.Globant.dto.AddStudentDto;
import org.Globant.dto.StudentDto;

import java.util.List;

public interface IStudentService {
    StudentDto addStudent(AddStudentDto addStudentDto);
    StudentDto getStudentByStudentId(int studentId);
    List<StudentDto> getStudents();
    StudentDto updateStudent(int id, AddStudentDto addStudentDto);
}
