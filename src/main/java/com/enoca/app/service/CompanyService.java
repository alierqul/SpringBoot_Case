package com.enoca.app.service;

import com.enoca.app.dto.request.DoCreateCompanyRequestDto;
import com.enoca.app.dto.request.DoUpdateCompanyRequestDto;
import com.enoca.app.dto.request.DoUpdateEmployeeRequestDto;
import com.enoca.app.repository.CompanyRepository;
import com.enoca.app.repository.EmployeeRepository;
import com.enoca.app.repository.entity.Company;
import com.enoca.app.repository.entity.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;

    public Company getCompanyById(long id){
        log.debug("ALi : getCompanyById :"+id);
        Optional<Company> inDB=Optional.of(companyRepository.getById(id));
        if(!inDB.isPresent()){
            throw new EntityNotFoundException("Company don't find: "+id);
        }
        return inDB.get();
    }

    public Company createCompany(DoCreateCompanyRequestDto company){
        Company inDB=new Company();
                inDB.setName(company.getName());
                inDB.setDescription(company.getDescription());

        return companyRepository.save(inDB);
    }

    public Company updateCompany(DoUpdateCompanyRequestDto company){

        Company inDB=getCompanyById(company.getId());
        inDB.setName(company.getName());
        inDB.setDescription(company.getDescription());
        return companyRepository.save(inDB);
    }

    public String deleteCompany(long id){
        Company inDB=getCompanyById(id);
        companyRepository.delete(inDB);
        return "Deleted";
    }

    public List<Company> getAllCompany(){
        return companyRepository.findAll();
    }

    public String addEmployee(long companyID, long employeeID) {
       Company inDB=getCompanyById(companyID);
       Employee employee= employeeRepository.getById(employeeID);
       if(employee==null){
           throw new EntityNotFoundException("Employee not Found.");
       }
        employee.setCompany(inDB);
       employeeRepository.save(employee);
        return "add to Employee List";
    }

    public List<Employee> getAllEmployeesByID(long id){
        Company inDB=getCompanyById(id);
        return employeeRepository.findByCompany(inDB);
    }
}
