package kz.iitu.payroll.genericClasses;

import kz.iitu.payroll.DAO.EmployeeLib;
import kz.iitu.payroll.service.SalaryCalculatorService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class PayrollApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(config.class);
        SalaryCalculatorService salaryCalculatorService = context.getBean(SalaryCalculatorService.class);
        Scanner in = new Scanner(System.in);

        EmployeeLib employeeLib = context.getBean(EmployeeLib.class);
        while (true) {
            System.out.println("Choose: \n" +
                    "1. Create employee \n" +
                    "2. Delete employee \n" +
                    "3. Update employee \n" +
                    "4. List of employee \n" +
                    "0. exit");
            int choise = in.nextInt();
            switch (choise) {
                case 1:
                    System.out.println("Enter ID:");
                    int id = in.nextInt();
                    System.out.println("Full name of employee: ");
                    String fullName = in.next();
                    System.out.println("Enter salary:");
                    int salary = in.nextInt();
                    System.out.println("Enter hour rate:");
                    double hourRate = in.nextDouble();
                    System.out.println("Enter type of employee: ");
                    String typeEmployee = in.next();

                    employeeLib.create(id, fullName,salary,hourRate,0,typeEmployee);

                    break;

                case 2:
                    employeeLib.employeeList();
                    System.out.println("Enter ID of employee:");
                    int id1 = in.nextInt();

                    employeeLib.delete(id1);
                    break;

                case 3:
                    employeeLib.employeeList();
                    System.out.println("Enter ID of employee:");
                    int id2 = in.nextInt();

                    salaryCalculatorService.update(id2);
                    break;

                case 4:
                    employeeLib.employeeList();
                    break;

                case 0:

                    return;
            }
        }
    }

}
