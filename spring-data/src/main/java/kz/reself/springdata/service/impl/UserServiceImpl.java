package kz.reself.springdata.service.impl;

import kz.reself.springdata.entity.EmployeeType;
import kz.reself.springdata.entity.User;
import kz.reself.springdata.repository.UserRepository;
import kz.reself.springdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void rewardSalariedCommissionEmployees(double persent) {
        List<User> userList = userRepository.findByEmplType(EmployeeType.SALARIED_COMMISION);
        for (User user: userList) {
            //System.out.println(user.getFixedSalary());
            user.setFixedSalary(user.getFixedSalary()/100 * user.getCommRate());
            userRepository.save(user);
        }
    }

    @Override
    public User getByName(String name) {
        return userRepository.getByName(name);
    }

    @Override
    public void employeeList() {
        System.out.println(userRepository.findAll());
    }

    @Override
    public void createEmployee(User employee) {
        userRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void salaryHourlyEmployees() {
        List<User> userList = userRepository.findByEmplType(EmployeeType.HOURLY);
        for (User user: userList) {
            //System.out.println(user.getFixedSalary());
            if (user.getHoursWorked()>39) {
                user.setFixedSalary(user.getFixedSalary()*1.5);
                userRepository.save(user);
            }
        }

    }

    @Override
    public void salaryCommision() {
        List<User> userList = userRepository.findByEmplType(EmployeeType.COMMISION);
        for (User user: userList) {
            //System.out.println(user.getFixedSalary());
            user.setFixedSalary(user.getCommRate());
        }
    }
}
