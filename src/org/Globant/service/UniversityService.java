package org.Globant.service;

public final class UniversityService implements IUniversityService{
    private static UniversityService instance;

    private final TeacherService teacherS;
    private final StudentService studentS;
    private final ClassroomService classroomS;

    private UniversityService(){
        this.teacherS = new TeacherService();
        this.studentS = new StudentService();
        this.classroomS = new ClassroomService();
    }

    public static UniversityService getInstance(){
        if (instance == null){
            instance = new UniversityService();
        }
        return instance;
    }

    @Override
    public TeacherService getTeacherS() {
        return this.teacherS;
    }

    @Override
    public StudentService getStudentS() {
        return studentS;
    }

    @Override
    public ClassroomService getClassroomS() {
        return classroomS;
    }
}
