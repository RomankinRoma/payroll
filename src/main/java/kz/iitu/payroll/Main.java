package kz.iitu.payroll;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        PayrollSystem payrollSystem= new PayrollSystem();
        payrollSystem.menuShow();
    }
}
