package org.Globant.dto;

public class TeacherDto extends PersonDto {
    private int id;
    private double salary;
    private boolean isPartialTime;

    public TeacherDto(){}

    public TeacherDto(int id, String name, double salary, boolean isPartialTime) {
        super(name);
        this.id = id;
        this.salary = salary;
        this.isPartialTime = isPartialTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "NAME: " + super.getName() + ", SALARY: " + salary + ", IS PARTIAL TIME: " + isPartialTime;
    }
}