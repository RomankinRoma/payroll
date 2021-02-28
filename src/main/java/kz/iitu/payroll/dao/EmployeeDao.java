package kz.iitu.payroll.dao;

import kz.iitu.payroll.event.SalaryChangeEvent;
import kz.iitu.payroll.model.Employee;
import kz.iitu.payroll.model.EmployeeType;
import kz.iitu.payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class EmployeeDao implements ApplicationEventPublisherAware {

//    @Value("${db.url}")
//    String url;
//    @Value("${db.username}")
//    String user;
//    @Value("${db.password}")
//    String password;
//    Connection connection;
//    private Statement stmt;
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private EmployeeRepository employeeRepository;
//    @PostConstruct
//    private void initialize() throws SQLException {
//        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
//        setDataSource((DataSource) connection);
//        System.out.println("Connected");
//    }

    public Employee create(Employee employee) throws SQLException {
//        String sql = "INSERT INTO Employee values("+id+", "+fullName+", "+salary+", "+type.toString()+")";
//        stmt = connection.createStatement();
//        ResultSet rs = stmt.executeQuery(sql);
//        System.out.println("Employee created!");
        System.out.println("Created");
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(int id) {
//        String myQuery = "SELECT * FROM Employee WHERE id=?";
//        assert getJdbcTemplate() != null;
//        Employee employee = getJdbcTemplate().queryForObject(myQuery, new Object[]{id}, new EmployeeRowMapper());
        return employeeRepository.getById(id);
    }

    public void delete(int id) {
        employeeRepository.delete(employeeRepository.getById(id));
        System.out.println("Deleted");
    }

    public void updateSalary(int id, Double salary) {
        Employee employee= employeeRepository.getById(id);
        employee.setSalary(salary);
        employeeRepository.save(employee);
        System.out.println("Updated");
    }

    public List<Employee> getList() {
//        String sql ="SELECT * FROM Employee";
//        return getJdbcTemplate().query(sql, new EmployeeRowMapper());
        return  employeeRepository.findAll();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
