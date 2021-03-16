package com.my.grocery.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@javax.persistence.Table(name = "role", uniqueConstraints =  {@UniqueConstraint(columnNames =  {"role_id"})})
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long roleId;

    @Basic(fetch = FetchType.EAGER, optional = true)
    @Column(name = "name", length = 64)
    @Length(max = 64)
    protected String name;
}
