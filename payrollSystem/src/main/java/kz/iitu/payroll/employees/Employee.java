package kz.iitu.payroll.employees;

import java.io.Serializable;

public class Employee implements Serializable {
    private int ID;
    private String fullName;
    private int salary;
    private double hourRate;
    private int hoursWorked;
    private String typeEmployee;

    public Employee(int ID, String fullName, int salary, double hourRate, int hoursWorked, String typeEmployee) {
        this.ID = ID;
        this.fullName = fullName;
        this.salary = salary;
        this.hourRate = hourRate;
        this.hoursWorked = hoursWorked;
        this.typeEmployee = typeEmployee;
    }

    public Employee() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getHourRate() {
        return hourRate;
    }

    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getTypeEmployee() {
        return typeEmployee;
    }

    public void setTypeEmployee(String typeEmployee) {
        this.typeEmployee = typeEmployee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", fullName='" + fullName + '\'' +
                ", salary=" + salary +
                ", hourRate=" + hourRate +
                ", hoursWorked=" + hoursWorked +
                ", typeEmployee='" + typeEmployee + '\'' +
                '}';
    }
}
