package com.lloyd.restAPICrudDemo.DAO;

import com.lloyd.restAPICrudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //that's all
}
