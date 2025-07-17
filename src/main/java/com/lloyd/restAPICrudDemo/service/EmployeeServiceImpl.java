package com.lloyd.restAPICrudDemo.service;

import com.lloyd.restAPICrudDemo.DAO.EmployeeDAO;
import com.lloyd.restAPICrudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    //setup constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){

        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
