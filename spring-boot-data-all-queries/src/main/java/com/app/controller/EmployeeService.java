package com.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.app.entity.Employee;
import com.app.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void getEmployeeById(Integer id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent())
			employee.ifPresent(x -> System.out.println(x));
		else
			System.out.println("Employee Not Found");
	}

	public void getAllEmployees() {
		List<Employee> list = employeeRepository.findAll();
		if (list.isEmpty())
			list.forEach(x -> System.out.println(x));
		else
			System.out.println("Employee Not Found");
	}

	public void addEmployee(Employee employee) {
		boolean flag = employeeRepository.save(employee) != null;
		if (flag == false) {
			System.out.println("Employee Not Saved");
		}
		System.out.println("Employee Saved Successfuly");
	}

	public void updateEmployee(Employee employee) {
		boolean flag = employeeRepository.save(employee) != null;
		if (flag == false) {
			System.out.println("Employee Not Updated");
		}
		System.out.println("Employee updated Successfuly");
	}

	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
		System.out.println("Employee Delete by" + id + "perosn id");
	}

	public void getEmployeeByEmail(String email) {
		Employee employee = employeeRepository.findEmployeeByEmail(email);
		if (employee != null)
			Arrays.asList(employee).forEach(System.out::println);
		else
			System.out.println("Employee Not Found");
	}

	public void findByAccountNumber(String accountNumber) {
		Employee employee = employeeRepository.findByAccountsAccountNumber(accountNumber);
		if (employee != null)
			Arrays.asList(employee).forEach(System.out::println);
		else
			System.out.println("Employee Not Found");
	}

	public void findAllEmployeesOrderByNameAsc() {
		List<Employee> list = employeeRepository.findAll(Sort.by("firstName"));
		if (list.isEmpty())
			list.forEach(System.out::println);
		else
			System.out.println("Employee Not Found");
	}

	public void findAllEmployeesOrderByNameDesc() {
		List<Employee> list = employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "firstName"));
		if (list.isEmpty())
			list.forEach(System.out::println);
		else
			System.out.println("Employee Not Found");
	}

	public void findByNameAndEmail(String firstName, String email) {
		Employee employee = employeeRepository.findByFirstNameAndEmail(firstName, email);
		if (employee != null)
			Arrays.asList(employee).forEach(System.out::println);
		else
			System.out.println("Employee Not Found");
	}

	public void findByEmployeeBySalary(Double salary) {
		employeeRepository.getParticularSalaryWiseEmployee(salary).forEach(System.out::println);
	}

	public Double findBySalarySum() {
		return employeeRepository.getAllSumBySalary();
	}

}
