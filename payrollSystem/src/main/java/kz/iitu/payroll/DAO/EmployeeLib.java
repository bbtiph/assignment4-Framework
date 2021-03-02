package kz.iitu.payroll.DAO;

import kz.iitu.payroll.employees.Employee;
import kz.iitu.payroll.event.SalaryChangeEvent;
import kz.iitu.payroll.event.SalaryChangeEventHandler;
import kz.iitu.payroll.genericClasses.config;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

@Component
public class EmployeeLib extends JdbcDaoSupport implements ApplicationEventPublisherAware, EmployeeDAO{
    private ApplicationEventPublisher eventPublisher;
    @PostConstruct
    public void initMethod() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/firstDB");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123");
        setDataSource(dataSource);
        System.out.println("Connected");
    }

    @Override
    public void create(int id, String fullname, int salary, double hourrate, int hoursworked, String employeeType) {
        getJdbcTemplate().update("INSERT INTO Employee VALUES (?,?,?,?,?,?,?)", id, fullname, salary, hourrate, hoursworked, employeeType);
    }

    @Override
    public void delete(int id) {
        getJdbcTemplate().update("delete from employee where id=?", id);
    }

    @Override
    public void update(int id, int choise) {

        Scanner in = new Scanner(System.in);
        switch (choise) {
            case 1:
                System.out.println("Enter full name:");
                String newFullName = in.next();
                getJdbcTemplate().update("update employee set fullname=? where id=?", newFullName, id);
                break;

            case 2:
                System.out.println("Enter new salary:");
                int newSalary = in.nextInt();
                getJdbcTemplate().update("update employee set salary=? where id=?", newSalary, id);
                this.eventPublisher.publishEvent(new SalaryChangeEvent(this, getEmployee(id)));
                break;

            case 3:
                System.out.println("Enter new type of employee: ");
                String newType = in.next();
                getJdbcTemplate().update("update employee set employeetype=? where id=?", newType, id);
                break;
        }


    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = getJdbcTemplate().queryForObject("SELECT * FROM employee WHERE id=?", new Object[]{id}, new EmployeeRowMapper());
        return employee;
    }

    @Override
    public void employeeList() {
        getJdbcTemplate().update("select * from employee");
    }

    public EmployeeLib(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

}
