package com.enoca.app.service;

import com.enoca.app.dto.request.DoCreateEmployeeRequestDto;
import com.enoca.app.dto.request.DoUpdateEmployeeRequestDto;
import com.enoca.app.repository.EmployeeRepository;
import com.enoca.app.repository.entity.Company;
import com.enoca.app.repository.entity.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CompanyService companyService;

    public Employee getEmployeeById(long id){
        Optional<Employee> inDB=employeeRepository.findById(id);
        if(!inDB.isPresent()){
            throw new EntityNotFoundException("Employee don't find: "+id);
        }
        return inDB.get();
    }

    public Employee createEmployee(DoCreateEmployeeRequestDto employee){
        Employee inDB= Employee.builder()
                .firsName(employee.getFirsName())
                .lastName(employee.getLastName())
                .phone(employee.getPhone())
                .build();
        return employeeRepository.save(inDB);
    }

    public Employee updateEmployee(DoUpdateEmployeeRequestDto employee){
        Employee inDB=getEmployeeById(employee.getId());

       inDB.setFirsName(employee.getFirsName());
       inDB.setLastName(employee.getLastName());
       inDB.setEmail(employee.getEmail());
       inDB.setPhone(employee.getPhone());
       if(employee.getCompanyId()!=null && employee.getCompanyId()>0){
           inDB.setCompany(companyService.getCompanyById(employee.getCompanyId()));
       }

        return employeeRepository.save(inDB);
    }

    public String deleteEmployee(long id){
        Employee inDB=getEmployeeById(id);
        employeeRepository.delete(inDB);
        return "Deleted.";
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

}
