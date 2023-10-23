package org.Globant.ui;


import java.util.Scanner;

public class UI {
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
}

