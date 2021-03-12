package kz.reself.springdata.controller;

import kz.reself.springdata.entity.User;
import kz.reself.springdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public User findByName(String name) {
        return userService.findByName(name);
    }

    public void createEmployee(User employee) {
        userService.createEmployee(employee);
    }

    public void employeeList() {
        userService.employeeList();
    }

    public void deleteEmployee(Long id) {
        userService.deleteEmployee(id);
    }

    public void updateEmployee(Long id) {}

    public void rewardSalariedCommissionEmployees(int persent) {
        userService.rewardSalariedCommissionEmployees(persent);
    }

    public void salaryHourlyEmployees(){
        userService.salaryHourlyEmployees();
    }
    public void salaryCommision(){
        userService.salaryCommision();
    }
}
