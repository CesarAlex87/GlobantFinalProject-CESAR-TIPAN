package org.Globant.service;

import org.Globant.dto.AddClassroomDto;
import org.Globant.dto.ClassroomDto;
import org.Globant.dto.StudentDto;

import java.util.List;

public interface IClassroomService {
    ClassroomDto addClassroom(AddClassroomDto addClassroomDto);
    ClassroomDto getClassroom(String classNumber);
    List<ClassroomDto> getClassrooms();
    ClassroomDto updateClassroom(String classNumber, AddClassroomDto addClassroomDto);
    void addStudentToClassroom(StudentDto studentToAdd, String classNumber);
}
