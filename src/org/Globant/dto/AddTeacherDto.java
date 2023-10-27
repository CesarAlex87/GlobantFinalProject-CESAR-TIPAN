package org.Globant.dto;

public class AddTeacherDto extends AddPersonDto{
    private double salary;
    private boolean isPartialTime;

    public AddTeacherDto(String name, double salary, boolean isPartialTime) {
        super(name);
        this.salary = salary;
        this.isPartialTime = isPartialTime;
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

    public void setPartialTime(boolean isPartialTime) {
        this.isPartialTime = isPartialTime;
    }
}
