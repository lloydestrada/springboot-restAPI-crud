package com.lloyd.restAPICrudDemo.rest;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lloyd.restAPICrudDemo.entity.Employee;
import com.lloyd.restAPICrudDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private ObjectMapper objectMapper;
    private EmployeeService employeeService;

    //inject employee directly
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService, ObjectMapper theObjectMapper){
        employeeService = theEmployeeService;
        objectMapper = theObjectMapper;
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


    //add mapping for PATCH /employees/{employeeId} - patch employee (partial update)
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,
                                  @RequestBody Map<String, Object> patchPayLoad) {

        Employee tempEmployee = employeeService.findById(employeeId);

        //throw exception
        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found: " + employeeId);
        }

        if(patchPayLoad.containsKey("id")){
            throw  new RuntimeException("Employee id not allowed in request body: " + employeeId);
        }

        Employee patchedEmployee = apply(patchPayLoad, tempEmployee);

        Employee dbEmployee = employeeService.save(patchedEmployee);

        return dbEmployee;
    }

    private Employee apply(Map<String, Object> patchPayLoad, Employee tempEmployee) {

        //Convert employee object to a JSON object node
        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);

        //Convert the patchPayLoad map to a JSON object node
        ObjectNode patchNode = objectMapper.convertValue(patchPayLoad, ObjectNode.class);

        //Merge the patch updates into the employee node
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    //Add mapping for DELETE /employees/{employeeId} - delete the employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee == null){
            throw new RuntimeException("Employee does not exsit: " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employeed ID: " + employeeId;
    }
}