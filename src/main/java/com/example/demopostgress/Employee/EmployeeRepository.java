package com.example.demopostgress.Employee;

import com.example.demopostgress.DemoPostgressApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    public static void main(String[] args) {
    }
}
