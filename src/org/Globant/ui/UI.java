package org.Globant.ui;

import org.Globant.dto.AddStudentDto;
import org.Globant.service.IStudentService;

import java.util.Scanner;

public class UI {
    private final IStudentService studentService;

    // Siempre hacer uso de inyeccion de dependencias, no crear instancias de objetos dentro de otros objetos
    public UI(IStudentService studentService) { this.studentService = studentService; }

    public void menu(){
        int option;
        do {
            var reader = new Scanner(System.in);
            System.out.println("[1] Print all teachers");
            System.out.println("[2] Print all classes (has to be a submenu)");
            System.out.println("[3] Create a Student and add him to an existing class");
            System.out.println("[4] Create a new classroom");
            System.out.println("[5] List all classes where a specific student is enrolled");
            System.out.println("[6] Exit");
            option = reader.nextInt();
            switch (option) {
                case 1:
                    this.listStudent();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    option = 0;
                    break;
            }
        }while(option!=0);
    }

    private void addStudent() {
        var reader = new Scanner(System.in);

        System.out.println("Enter student name");
        var name = reader.nextLine();

        System.out.println("Enter student's age");
        var age = reader.nextInt();

        // podrias hacer las validaciones aca o mejor aun en el DTO y tirar exceptions desde ahi :)
        var addStudentDto = new AddStudentDto(name, age);
        studentService.addStudent(addStudentDto);
    }

    private void listStudent() {
        this.studentService.getStudents().forEach(student -> {
            System.out.println(student.toString());
        });
    }
}

