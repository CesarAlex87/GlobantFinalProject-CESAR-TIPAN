package org.Globant.service;

import org.Globant.domain.Classroom;
import org.Globant.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ClassroomService implements IClassroomService{
    private final List<Classroom> classrooms = new ArrayList<>();

    public ClassroomService() {
        initClassrooms();
    }

    @Override
    public List<ClassroomDto> getAllClassroomsByStudent(StudentDto studentSearched) {
        List<ClassroomDto> classroomsWithStudent = new ArrayList<>();

        for (Classroom classroom : classrooms) {
            for (StudentDto student : classroom.getClassStudents()) {
                if (student.getStudentId() == studentSearched.getStudentId()) {
                    classroomsWithStudent.add(new ClassroomDto(
                            classroom.getName(),
                            classroom.getClassNumber(),
                            classroom.getClassStudents(),
                            classroom.getTeacher()
                    ));
                    break;
                }
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

    private void initClassrooms() {
        classrooms.add(new Classroom("FÍSICA", "201", new ArrayList<StudentDto>(), new TeacherDto()));
        classrooms.add(new Classroom("PROGRAMACIÓN AVANZADA", "202", new ArrayList<StudentDto>(), new TeacherDto()));
        classrooms.add(new Classroom("INTELIGENCIA ARTIFICIAL", "203", new ArrayList<StudentDto>(), new TeacherDto()));
        classrooms.add(new Classroom("QUÍMICA ORGÁNICA", "204", new ArrayList<StudentDto>(), new TeacherDto()));
        classrooms.add(new Classroom("ECONOMÍA MICROECONÓMICA", "205", new ArrayList<StudentDto>(), new TeacherDto()));
        classrooms.add(new Classroom("DISEÑO GRÁFICO", "206", new ArrayList<StudentDto>(), new TeacherDto()));
        classrooms.add(new Classroom("MATEMÁTICAS DISCRETAS", "207", new ArrayList<StudentDto>(), new TeacherDto()));
        classrooms.add(new Classroom("ADMINISTRACIÓN DE EMPRESAS", "208", new ArrayList<StudentDto>(), new TeacherDto()));
        classrooms.add(new Classroom("PROGRAMACIÓN WEB", "209", new ArrayList<StudentDto>(), new TeacherDto()));
        classrooms.add(new Classroom("HISTORIA DEL ARTE", "210", new ArrayList<StudentDto>(), new TeacherDto()));
    }

}
