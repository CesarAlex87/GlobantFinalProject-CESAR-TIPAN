package org.Globant.dto;

public class AddTeacherDto {
    private String name;
    private double salary;
    private String contract;

    public AddTeacherDto(String name, double salary, String contract) {
        this.name = name;
        this.salary = salary;
        this.contract = contract;
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
}
