package kz.iitu.payroll.DAO;

import java.util.List;
import kz.iitu.payroll.employees.Employee;

public interface EmployeeDAO {
    void create(int id, String fullname, int salary, double hourrate, int hoursworked, String employeeType);
    void delete(int id);
    void update(int id, int choise);
    void employeeList();
    Employee getEmployee(int id);
}
