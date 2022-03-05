package com.enoca.app.repository;

import com.enoca.app.repository.entity.Company;
import com.enoca.app.repository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByCompany(Company company);
}
