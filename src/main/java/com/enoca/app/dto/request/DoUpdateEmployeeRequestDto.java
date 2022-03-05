package com.enoca.app.dto.request;

import com.enoca.app.repository.entity.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoUpdateEmployeeRequestDto {
    @NotNull
    @Min(0)
    private long id;
    private String firsName;
    private String lastName;
    private String phone;
    private String email;
    private Long companyId;

    public DoUpdateEmployeeRequestDto(Employee e){
        this.id=e.getId();
        this.firsName=e.getFirsName();
        this.lastName=e.getLastName();
        this.phone=e.getPhone();
        this.email=e.getEmail();
        this.companyId=e.getCompany().getId();
    }
    public DoUpdateEmployeeRequestDto(Employee e,long companyId){
        this.id=e.getId();
        this.firsName=e.getFirsName();
        this.lastName=e.getLastName();
        this.phone=e.getPhone();
        this.email=e.getEmail();
        this.companyId=companyId;
    }
}
