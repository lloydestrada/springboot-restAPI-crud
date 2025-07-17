package com.lloyd.restAPICrudDemo.DAO;

import com.lloyd.restAPICrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findId(int theId);

    Employee save (Employee theEmployee);

    void deleteById(int theId);
}
