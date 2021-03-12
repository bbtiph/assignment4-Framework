package kz.reself.springdata.repository;

import kz.reself.springdata.entity.EmployeeType;
import kz.reself.springdata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByName(String name);
//    @Query(value = "update User set fixedSalary=fixedSalary*?1 where emplType=?2 and hoursWorked>=40")
//    void salaryHourlyEmployee(double percent, EmployeeType employeeType);
    List<User> findByEmplType(EmployeeType employeeType);
    User findByName(String name);
}
