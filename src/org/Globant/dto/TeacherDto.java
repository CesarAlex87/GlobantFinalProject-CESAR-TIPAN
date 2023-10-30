package org.Globant.dto;

import org.Globant.utils.AppConstants;

public class TeacherDto extends PersonDto {
    private int id;
    private double salary;
    private boolean isPartialTime;
    public int yearsOfExperience;

    public TeacherDto(){}

    public TeacherDto(int id, String name, double salary, boolean isPartialTime) {
        super(name);
        this.id = id;
        this.salary = AppConstants.BASIC_SALARY;
        this.isPartialTime = isPartialTime;
        this.yearsOfExperience = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return this.salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isPartialTime() {
        return isPartialTime;
    }

    public void setPartialTime(boolean partialTime) {
        isPartialTime = partialTime;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
        if(yearsOfExperience!=0){
            setSalary(AppConstants.BASIC_SALARY * (1.1 * yearsOfExperience));
        }
    }

    @Override
    public String toString() {
        return "NAME: " + super.getName() + ", SALARY: " + salary + ", IS PARTIAL TIME: " + isPartialTime;
    }
}