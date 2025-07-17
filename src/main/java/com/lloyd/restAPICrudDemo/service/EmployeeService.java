package com.lloyd.restAPICrudDemo.service;

import com.lloyd.restAPICrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findId(int theId);

    Employee save (Employee theEmployee);

    void deleteById(int theId);

    Employee findById(int employeeId);
}
