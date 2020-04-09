package com.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "email", unique = true, nullable = false, length = 100)
	private String email;

	@Column(name = "first_name", unique = false, nullable = false, length = 100)
	private String firstName;

	@Column(name = "last_name", unique = false, nullable = false, length = 100)
	private String lastName;

	@Column(name = "salary")
	private Double salary;

	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Account> accounts;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", salary=" + salary + ", accounts=" + accounts + "]";
	}

}
