package org.Globant.ui;

import org.Globant.domain.Classroom;
import org.Globant.domain.Student;
import org.Globant.dto.AddClassroomDto;
import org.Globant.dto.AddStudentDto;
import org.Globant.dto.ClassroomDto;
import org.Globant.dto.StudentDto;
import org.Globant.service.IClassroomService;
import org.Globant.service.IStudentService;
import org.Globant.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {
    private final IStudentService studentService;
    private final ITeacherService teacherService;
    private final IClassroomService classroomService;

    public UI(IStudentService studentService, ITeacherService teacherService, IClassroomService classroomService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.classroomService = classroomService;
    }

    public void menu(){
        int option;
        do {
            var reader = new Scanner(System.in);
//            clearConsole();
            System.out.println("--X UNIVERSITY SYSTEM--");
            System.out.println("[1] Print all teachers");
            System.out.println("[2] Print all classes (has to be a submenu)");
            System.out.println("[3] Create a Student and add him to an existing class");
            System.out.println("[4] Create a new classroom");
            System.out.println("[5] List all classes where a specific student is enrolled");
            System.out.println("[6] Exit");
            option = reader.nextInt();
            switch (option) {
                case 1:
                    this.listTeachers();
                    break;
                case 2:
                    this.ListClassroomsWithDescription();
                    break;
                case 3:
                    this.createStudent();
                    break;
                case 4:
                    createClassroom();
                    break;
                case 5:
                    listClassroomsForOneStudent();
                    break;
                case 6:
                    option = 0;
                    break;
                default:
                    System.out.println("Invalid Option!, please try again");
                    break;
            }
        }while(option!=0);
    }

    private void listClassroomsForOneStudent(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Insert the Student ID: ");

        List<ClassroomDto> classroomsList = classroomService.getAllClassroomsByStudent(
                studentService.getStudentByStudentId(
                        reader.nextInt()
                )
        );

        classroomsList.forEach(classroom -> {
            System.out.println("CLASS NAME: " + classroom.getName() + " , CLASS NUMBER: " + classroom.getClassNumber());
        });
    }

    private void createStudent() {
        var reader = new Scanner(System.in);

        System.out.println("Enter student full name: ");
        var name = reader.nextLine();

        System.out.println("Enter student's age: ");
        var age = reader.nextInt();
        reader.nextLine();
        var addStudentDto = new AddStudentDto(name, age);
        var studentToAdd = studentService.addStudent(addStudentDto);

        System.out.println("Please select the class from the list below for this student.");
        listClassrooms();
        System.out.println("\nEnter the class number: ");
        var classNumber = reader.nextLine();

        classroomService.addStudentToClassroom(studentToAdd, classNumber);
    }

    private void createClassroom() {
            var reader = new Scanner(System.in);
            var finishSelection = "A";
            List<StudentDto> auxiliarList = new ArrayList<>();
            ArrayList<StudentDto> studentsClassList = new ArrayList<>();

            System.out.println("Enter the name of the classroom(Subject): ");
            var name = reader.nextLine();

            System.out.println("Enter the class number: ");
            var classNumber = reader.nextLine();

            System.out.println("Select one of the following teachers");
            listTeachers();

            System.out.println("Enter the teacher's [id]: ");
            var teacherId = reader.nextInt();
            var teacherSelected = teacherService.getTeacher(teacherId);

            System.out.println("Select from the following list all the students you want to add to the classroom");
            auxiliarList = new ArrayList<>(studentService.getStudents());

            var flag = 1;
            do {
                reader.nextLine();
                auxiliarList.forEach(student -> {
                    System.out.println("[" + student.getStudentId() + "] " + student.toString());
                });
                System.out.println("Do you want to add a more students?\n[Y] Yes [N] No");
                finishSelection = reader.nextLine();

                switch (finishSelection){
                    case "Y":
                        System.out.println("Enter the student ID: ");
                        var studentId = reader.nextInt();
                        var studentSelected = auxiliarList.stream()
                                .filter(student -> student.getStudentId() == studentId)
                                .findFirst()
                                .orElse(null);

                        if (studentSelected != null) {
                            studentsClassList.add(studentSelected);
                            auxiliarList.remove(studentSelected);
                        } else {
                            System.out.println("Student with ID " + studentId + " not found.");
                        }
                        break;
                    case "N":
                        flag = 0;
                        break;
                    default:
                        System.out.println("Invalid option, please try again");
                        break;
                }

            }while(flag!=0);

            classroomService.addClassroom(new AddClassroomDto(name, classNumber, studentsClassList, teacherSelected));
            System.out.println("Classroom created successfully, going back to main menu");
    }

    private void listStudents(){
        this.studentService.getStudents().forEach(student -> {
            System.out.println("[" + student.getStudentId() + "] " + student.toString());
        });
    }

    private void listTeachers() {
        System.out.println("--TEACHERS LIST--\n");
        this.teacherService.getTeachers().forEach(teacher -> {
            System.out.println("[" + teacher.getId() + "] " + teacher.toString());
        });
    }

    private void listClassrooms(){
        this.classroomService.getClassrooms().forEach(classroom -> {
            System.out.println("CLASS NAME: " + classroom.getName() + " , CLASS NUMBER: " + classroom.getClassNumber());
        });
    }

    private void ListClassroomsWithDescription(){
        var sc = new Scanner(System.in);
        int option;
        var reader = new Scanner(System.in);

        System.out.println("\n--CLASSROOMS LIST--\n");
        this.classroomService.getClassrooms().forEach(classroom -> {
            System.out.println("CLASS NAME: " + classroom.getName() + " , CLASS NUMBER: " + classroom.getClassNumber());
        });
        do {
            System.out.println("\n\n\n[1] Show class information.\n[2] Back to main menu\n");
            option = sc.nextInt();
            switch (option){
                case 1:
                    System.out.println("Enter the class number: ");
                    var classNumber = reader.nextLine();
                    System.out.println((classroomService.getClassroom(classNumber)).toString());
                    break;
                case 2:
                    option = 0;
                    break;
            }
        }while(option!=0);
    }

    private void clearConsole(){
        for(int i=0; i<25; i++){
            System.out.println("\n");
        }
    }
}