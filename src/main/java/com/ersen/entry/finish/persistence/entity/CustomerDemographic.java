package com.ersen.entry.finish.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "CustomerDemographics")
public class CustomerDemographic implements Serializable {
    private static final long serialVersionUID = -5673807417624143459L;

    @Id
    @Column(name = "CustomerTypeID")
    private String customerTypeId;

    @Column(name = "CustomerDesc")
    private String customerDesc;

    @ManyToMany(mappedBy = "customerDemographics", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Customer> customers;
}
