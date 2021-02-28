package kz.iitu.payroll;

import kz.iitu.payroll.config.Config;
import kz.iitu.payroll.dao.EmployeeDao;
import kz.iitu.payroll.model.EmployeeType;
import kz.iitu.payroll.service.SalaryCalculatorService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class PayrollSystem {
    public void menuShow() throws SQLException {
        Scanner in = new Scanner(System.in);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        EmployeeDao employeeDAO = context.getBean(EmployeeDao.class);

        SalaryCalculatorService service = context.getBean(SalaryCalculatorService.class);

        int choice = -1;

        while (choice != 0) {
            System.out.println("1. Add user");
            System.out.println("2. Update salary");
            System.out.println("3. List of Employees");
            System.out.println("0. Exit");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    service.create(employeeDAO);
                    break;
                case 2:
                    service.updateSalary(employeeDAO);
                    break;
                case 3:
                    service.listOfEmployees(employeeDAO);
                    break;
                case 0:
                    return;
            }
        }
    }
}
