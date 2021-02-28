package kz.iitu.payroll.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("kz.iitu.payroll")
@PropertySource("application.properties")
public class Config {
}
