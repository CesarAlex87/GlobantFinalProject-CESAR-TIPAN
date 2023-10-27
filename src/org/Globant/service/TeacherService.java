package org.Globant.service;

import org.Globant.domain.Teacher;
import org.Globant.dto.AddTeacherDto;
import org.Globant.dto.TeacherDto;

import java.util.ArrayList;
import java.util.List;

public class TeacherService implements ITeacherService{
    private final List<Teacher> teachers = new ArrayList<>();
    private int currentId = 1;

    public TeacherService(){
        this.addTeacher(new AddTeacherDto());
    }

    private int getNextId(){ return currentId++; }

    @Override
    public TeacherDto addTeacher(AddTeacherDto addTeacherDto) {
        var teacher = new Teacher(addTeacherDto.getName(), addTeacherDto.getSalary(), addTeacherDto.getContract());
        teachers.add(teacher);

        return new TeacherDto(this.getNextId(), teacher.getName(), teacher.getSalary(), teacher.getContract());
    }

    @Override
    public TeacherDto getTeacher(int id) {
        return null;
    }

    @Override
    public List<TeacherDto> getTeacher() {
        return null;
    }

    @Override
    public TeacherDto updateTeacher(int id, AddTeacherDto addTeacherDto) {
        return null;
    }
}
