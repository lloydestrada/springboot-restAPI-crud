package com.lloyd.restAPICrudDemo.rest;



import com.lloyd.restAPICrudDemo.entity.Employee;
import com.lloyd.restAPICrudDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //inject employee directly
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){

        return employeeService.findAll();
    }

    //add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findId(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

    //add a mapping for POST/ADD /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        //set id to 0
        //NOTE: this is to force a save a new item - instead of updating

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    //add mapping for PUT /employees - update an existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

}
