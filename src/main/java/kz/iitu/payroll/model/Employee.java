package kz.iitu.payroll.model;

import lombok.Data;
import lombok.Generated;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String fullName;
    private Double salary;
    private EmployeeType employeeType;
}
