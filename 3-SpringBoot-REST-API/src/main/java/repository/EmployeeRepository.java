package com.example.springbootrestapi.repository;

import com.example.springbootrestapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}