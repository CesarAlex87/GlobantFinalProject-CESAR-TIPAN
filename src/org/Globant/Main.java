package org.Globant;

import org.Globant.service.ClassroomService;
import org.Globant.service.TeacherService;
import org.Globant.ui.UI;
import org.Globant.service.StudentService;

public class Main {
    public static void main(String[] args) {
        var studentService = new StudentService();
        var teacherService = new TeacherService();
        var classroomService = new ClassroomService();
        var ui = new UI(studentService, teacherService, classroomService);
        ui.menu();
    }
}
