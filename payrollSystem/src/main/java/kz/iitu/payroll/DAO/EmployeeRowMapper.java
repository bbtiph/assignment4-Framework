package kz.iitu.payroll.DAO;

import kz.iitu.payroll.employees.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();

        employee.setID(resultSet.getInt("id"));
        employee.setFullName(resultSet.getString("fullname"));
        employee.setSalary(resultSet.getInt("salary"));
        employee.setHourRate(resultSet.getDouble("hourrate"));
        employee.setHoursWorked(resultSet.getInt("hoursworked"));
        employee.setTypeEmployee(resultSet.getString("employeetype"));

        return employee;
    }
}
