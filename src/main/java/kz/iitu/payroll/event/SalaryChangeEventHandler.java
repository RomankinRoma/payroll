package kz.iitu.payroll.event;

import org.springframework.context.ApplicationListener;

public class SalaryChangeEventHandler implements ApplicationListener<SalaryChangeEvent> {
    @Override
    public void onApplicationEvent(SalaryChangeEvent salaryChangeEvent) {
        System.out.println("Changing: " + salaryChangeEvent.getEmployee());
    }
}
