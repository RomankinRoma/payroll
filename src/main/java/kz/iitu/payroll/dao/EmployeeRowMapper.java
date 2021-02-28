package kz.iitu.payroll.dao;

import kz.iitu.payroll.model.Employee;
import kz.iitu.payroll.model.EmployeeType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

        Employee employee = new Employee();

        employee.setId(resultSet.getInt("id"));
        employee.setFullName(resultSet.getString("name"));
        employee.setSalary(resultSet.getDouble("salary"));
        employee.setEmployeeType(EmployeeType.valueOf(resultSet.getString("type")));

        return employee;
    }
}
