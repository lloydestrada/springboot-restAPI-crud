package com.lloyd.restAPICrudDemo.service;


import com.lloyd.restAPICrudDemo.DAO.EmployeeRepository;
import com.lloyd.restAPICrudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    //setup constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){

        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findId(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException ("Did not find employee id: " + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }

    @Override
    public Employee findById(int employeeId) {

        Optional <Employee> result = employeeRepository.findById(employeeId);

        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException ("Did not find employee id: " + employeeId);
        }
        return theEmployee;
    }
}
