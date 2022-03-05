package com.enoca.app.dto.response;

import com.enoca.app.repository.entity.Employee;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class GetEmployeeResponseDto {
    private long id;
    private String firsName;
    private String lastName;
    private String email;
    private String phone;
    private Date creationDate;
    private long companyId;

    public GetEmployeeResponseDto(Employee e){
        this.id=e.getId();
        this.firsName=e.getFirsName();
        this.lastName=e.getLastName();
        this.email=e.getEmail();
        this.phone=e.getPhone();
        this.creationDate=e.getCreationDate();
        if(e.getCompany()!=null){
            this.companyId=e.getCompany().getId();
        }
    }
}
