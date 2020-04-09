package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.controller.EmployeeService;

@SpringBootApplication
public class SpringBootDataOneToManyApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataOneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//employeeService.getEmployeeById(1);
		//employeeService.findByEmployeeBySalary(10000d);
		System.out.println(employeeService.findBySalarySum());
	}

}
