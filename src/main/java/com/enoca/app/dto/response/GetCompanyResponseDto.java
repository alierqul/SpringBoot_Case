package com.enoca.app.dto.response;

import com.enoca.app.repository.entity.Company;
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
public class GetCompanyResponseDto {
    private long id;
    private String name;
    private String description;
    private Date creationDate;

    public GetCompanyResponseDto(Company company){
        this.id=company.getId();
        this.name=company.getName();
        this.description=company.getDescription();
        this.creationDate=company.getCreationDate();
    }
}
