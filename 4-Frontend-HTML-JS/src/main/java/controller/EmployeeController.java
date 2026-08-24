package com.example.springbootrestapi.controller;

import com.example.springbootrestapi.entity.Employee;
import com.example.springbootrestapi.repository.EmployeeRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // 1. CREATE
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

        Employee savedEmployee = employeeRepository.save(employee);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // 2. GET ALL
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // 3. GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {

        return employeeRepository.findById(id)
                .map(employee -> new ResponseEntity<>(employee, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 4. UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employeeDetails) {

        return employeeRepository.findById(id)
                .map(employee -> {

                    employee.setName(employeeDetails.getName());
                    employee.setEmail(employeeDetails.getEmail());
                    employee.setDepartment(employeeDetails.getDepartment());
                    employee.setSalary(employeeDetails.getSalary());

                    Employee updatedEmployee =
                            employeeRepository.save(employee);

                    return new ResponseEntity<>(
                            updatedEmployee,
                            HttpStatus.OK
                    );
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 5. DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {

        if (!employeeRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        employeeRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}