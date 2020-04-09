package com.app.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "account_number", unique = true, nullable = false, length = 100)
	private String accountNumber;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + "]";
	}
}
