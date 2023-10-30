package org.Globant.domain;

public class Teacher extends Person{
    private int teacherId;
    private double salary;
    private boolean isPartialTime;
    private int yearsOfExperience;
    private int activeHoursPerWeek;

    public Teacher(int id, int teacherId , String name, double salary, boolean isPartialTime) {
        super(id, name);
        this.teacherId = teacherId;
        this.salary = salary;
        this.isPartialTime = isPartialTime;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isPartialTime() {
        return isPartialTime;
    }

    public void setPartialTime(boolean partialTime) {
        isPartialTime = partialTime;
    }
}
