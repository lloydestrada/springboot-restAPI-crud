package com.lloyd.restAPICrudDemo.service;

import com.lloyd.restAPICrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
