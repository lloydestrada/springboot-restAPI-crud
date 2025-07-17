package com.lloyd.restAPICrudDemo.DAO;

import com.lloyd.restAPICrudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{

    //define fields for entity manager
    private EntityManager entityManager;

    //setup constructor injection
    @Autowired
    public EmployeeDAOJPAImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {

        //create a query to find  the list
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;
    }

    @Override
    public Employee findId(int theId) {

        //retrieving the employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        //save or update
        Employee dbEmployee = entityManager.merge(theEmployee);

        //return
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        //find employee Id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //remove employee
        entityManager.remove(theEmployee);
    }
}
