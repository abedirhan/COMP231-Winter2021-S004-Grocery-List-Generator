package com.my.grocery.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@BatchSize(size = 10)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@FilterDef(name = "deletedEntityFilter")
@Filters({@Filter(name = "deletedEntityFilter",condition = "deleted <> 1")})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "party", uniqueConstraints =  {@UniqueConstraint(columnNames =  {"party_id"})})
public class Party {
    @Id
    @Column(name = "party_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long partyId;

    @Basic(fetch = FetchType.EAGER, optional = true)
    @Column(name = "email", length = 64)
    @Length(max = 64)
    protected String email;

    @OneToOne(targetEntity = Role.class, cascade =  {
            CascadeType.PERSIST, CascadeType.MERGE}
            , fetch = FetchType.LAZY, optional = true)
    @Cascade(value =  {
            org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST}
    )
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    protected Role role;

}
