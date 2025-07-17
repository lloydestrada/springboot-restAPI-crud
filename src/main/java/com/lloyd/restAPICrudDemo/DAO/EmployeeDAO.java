package com.lloyd.restAPICrudDemo.DAO;

import com.lloyd.restAPICrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
