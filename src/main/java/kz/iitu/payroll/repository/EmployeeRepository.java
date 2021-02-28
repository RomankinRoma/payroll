package kz.iitu.payroll.repository;

import kz.iitu.payroll.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee getById(Integer id);
}
