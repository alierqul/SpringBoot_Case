package com.enoca.app.repository;

import com.enoca.app.repository.entity.Company;
import com.enoca.app.repository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findById(Long id);

    List<Employee> findByCompany(Company company);
}
