package org.Globant.dto;

public class TeacherDto {
    private int id;
    private String name;
    private double salary;
    private String contract;

    public TeacherDto(){}

    public TeacherDto(int id, String name, double salary, String contract) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.contract = contract;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "NAME: " + name + ", SALARY: " + salary + ", CONTRACT: " + contract;
    }
}