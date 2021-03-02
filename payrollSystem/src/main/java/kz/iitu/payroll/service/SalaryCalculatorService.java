package kz.iitu.payroll.service;

import kz.iitu.payroll.DAO.EmployeeDAO;
import kz.iitu.payroll.DAO.EmployeeLib;
import kz.iitu.payroll.employees.Employee;
import kz.iitu.payroll.genericClasses.config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class SalaryCalculatorService {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(config.class);
    EmployeeLib employeeLib = context.getBean(EmployeeLib.class);


    public void update(int id) {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose: \n" +
                "1. Full name" +
                "\n2. Salary" +
                "\n3. Type of employee");
        int choise = in.nextInt();
        employeeLib.update(id, choise);
    }

}
