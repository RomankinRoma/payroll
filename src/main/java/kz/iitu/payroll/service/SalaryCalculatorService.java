package kz.iitu.payroll.service;

import kz.iitu.payroll.dao.EmployeeDao;
import kz.iitu.payroll.model.Employee;
import kz.iitu.payroll.model.EmployeeType;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@Service
public class SalaryCalculatorService {
    Scanner in = new Scanner(System.in);

    public void create(EmployeeDao employeeDao) throws SQLException {
        System.out.print("Enter name: ");
        String name = in.next();
        System.out.print("Enter salary: ");
        Integer salary = in.nextInt();

        System.out.println("Choose User Type: ");
        System.out.println("1." + EmployeeType.SALARIED);
        System.out.println("2." + EmployeeType.HOURLY);
        System.out.println("3." + EmployeeType.COMMISSION);
        System.out.println("4." + EmployeeType.SALARIED_COMMISSION);
        System.out.print("Choice : ");
        int choice = in.nextInt();

        EmployeeType type;

        switch (choice){
            case 1:
                type = EmployeeType.SALARIED;
                break;
            case 2:
                type = EmployeeType.HOURLY;
                break;
            case 3:
                type = EmployeeType.COMMISSION;
                break;
            case 4:
                type = EmployeeType.SALARIED_COMMISSION;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
        Employee employee = new Employee();
        employee.setEmployeeType(type);
        employee.setSalary(Double.valueOf(salary));
        employee.setFullName(name);
        employeeDao.create(employee);
    }

    public void updateSalary(EmployeeDao employeeDao) {
        System.out.print("Enter employee's ID: ");
        int id = in.nextInt();
        Employee employee = employeeDao.getEmployee(id);
        Double salary = employee.getSalary();

        System.out.println("1. Increase");
        System.out.println("2. Decrease");
        int choice =in.nextInt();

        if (choice == 1) {
            System.out.print("Enter percentage of increase: ");
            int per = in.nextInt();
            employeeDao.updateSalary(id, salary + salary * per / 100);
        } else {
            System.out.print("Enter percentage of decrease: ");
            int per = in.nextInt();
            employeeDao.updateSalary(id, salary - salary * per / 100);
        }
    }

    public void listOfEmployees(EmployeeDao employeeDao) {
        List<Employee> employees = employeeDao.getList();
        for (Employee employee: employees) {
            System.out.println(employee.toString());
        }
    }
}
