package org.Globant.service;

import org.Globant.domain.Teacher;
import org.Globant.dto.AddTeacherDto;
import org.Globant.dto.TeacherDto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TeacherService implements ITeacherService{
    private final List<Teacher> teachers = new ArrayList<>();
    private int currentTeacherId = 101;
    private int currentId = 1;

    public TeacherService(){
        teachers.add(new Teacher(getNextTeacherId(), getNextId() ,"Ing. Bryan Lopez", 0, true));
        teachers.add(new Teacher(getNextTeacherId(), getNextId(), "Ing. Adrian Gonzales", 0, false));
    }

    private int getNextTeacherId() { return currentTeacherId++; }

    private int getNextId(){ return currentId++; }

    private Teacher findTeacherById(int id) {
        return teachers.stream()
                .filter(teacher -> teacher.getTeacherId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public TeacherDto addTeacher(AddTeacherDto addTeacherDto) {
        var teacher = new Teacher(this.getNextId(), this.currentTeacherId, addTeacherDto.getName(), addTeacherDto.getSalary(), addTeacherDto.isPartialTime());
        teachers.add(teacher);

        return new TeacherDto(teacher.getTeacherId(), teacher.getName(), teacher.getSalary(), teacher.isPartialTime());
    }

    @Override
    public TeacherDto getTeacher(int id) {
        Teacher teacher = findTeacherById(id);

        if (teacher != null) {
            return new TeacherDto(teacher.getTeacherId(), teacher.getName(), teacher.getSalary(), teacher.isPartialTime());
        } else {
            throw new NoSuchElementException("Teacher not found or doesn't exist for ID: " + id);
        }
    }

    @Override
    public List<TeacherDto> getTeachers() {
        return teachers.stream()
                .map(teacher -> new TeacherDto(teacher.getTeacherId(), teacher.getName(), teacher.getSalary(), teacher.isPartialTime()))
                .toList();
    }

    @Override
    public TeacherDto updateTeacher(int id, AddTeacherDto addTeacherDto) {
        return null;
    }
}
