package org.Globant.service;

import org.Globant.dto.AddTeacherDto;
import org.Globant.dto.TeacherDto;

import java.util.List;

public interface ITeacherService {
    TeacherDto addTeacher(AddTeacherDto addTeacherDto);
    TeacherDto getTeacher(int id);
    List<TeacherDto> getTeacher();
    TeacherDto updateTeacher(int id, AddTeacherDto addTeacherDto);
}
