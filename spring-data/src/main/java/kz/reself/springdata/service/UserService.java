package kz.reself.springdata.service;

import kz.reself.springdata.entity.User;

import java.util.Collection;
import java.util.List;

public interface UserService {
    void rewardSalariedCommissionEmployees(double persent);
    User getByName(String name);
    void employeeList();
    void createEmployee(User employee);
    void deleteEmployee(Long id);
    void salaryHourlyEmployees();
    void salaryCommision();
    User findByName(String name);
}
