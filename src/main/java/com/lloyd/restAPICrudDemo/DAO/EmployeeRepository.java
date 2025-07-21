package com.lloyd.restAPICrudDemo.DAO;

import com.lloyd.restAPICrudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "testmembers")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //that's all
}
