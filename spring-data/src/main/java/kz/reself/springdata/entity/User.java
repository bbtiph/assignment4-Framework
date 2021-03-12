package kz.reself.springdata.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double fixedSalary;
    private double hourRate;
    private int hoursWorked;
    private float commRate;

    @Enumerated(EnumType.STRING)
    private EmployeeType emplType;

    public User(Long id, String name, double fixedSalary, double hourRate, int hoursWorked, float commRate, EmployeeType emplType) {
        this.id = id;
        this.name = name;
        this.fixedSalary = fixedSalary;
        this.hourRate = hourRate;
        this.hoursWorked = hoursWorked;
        this.commRate = commRate;
        this.emplType = emplType;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fixedSalary=" + fixedSalary +
                ", hourRate=" + hourRate +
                ", hoursWorked=" + hoursWorked +
                ", commRate=" + commRate +
                ", emplType=" + emplType +
                '}';
    }
}
