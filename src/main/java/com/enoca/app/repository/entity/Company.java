package com.enoca.app.repository.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TABLE_COMPANIES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date creationDate;
    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY)
    private Set<Employee> employees=new HashSet<>();

}
