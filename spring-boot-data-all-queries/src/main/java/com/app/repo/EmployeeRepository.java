package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public Employee findEmployeeByEmail(String email);

	public Employee findByAccountsAccountNumber(String accountNumber);

	public Employee findByFirstNameAndEmail(String firstName, String email);

	@Query(value = "FROM Employee e WHERE e.salary =:salary")
	public List<Employee> getParticularSalaryWiseEmployee(Double salary);

	@Query(value = "SELECT SUM(salary) FROM Employee", nativeQuery = true)
	public Double getAllSumBySalary();

}
