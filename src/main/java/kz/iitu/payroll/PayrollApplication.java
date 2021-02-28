package kz.iitu.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class PayrollApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(PayrollApplication.class, args);

    }

}
