package com.example.demopostgress.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    public static void main(String[] args) {
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    public Optional<Employee> findIndvEmployee(@PathVariable(value = "id") Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @GetMapping
    public List<Employee> findAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @PostMapping
    public Employee saveNewEmployee(@Validated @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeid, @Validated @RequestBody Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employeeid).orElseThrow(() -> new ExpressionException("Employee not found for this id :: " + employeeid));
        existingEmployee.setName(employee.getName());
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable(value = "id") Long employeeid) {
        employeeRepository.deleteById(employeeid);
    }


}
