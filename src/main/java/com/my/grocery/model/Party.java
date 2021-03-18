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
@Table(name = "party", uniqueConstraints =  {@UniqueConstraint(columnNames =  {"party_id"})})
public class Party {
    @Id
    @Column(name = "party_id")
    protected String partyId;

    @Basic(fetch = FetchType.EAGER, optional = true)
    @Column(name = "email", length = 64)
    @Length(max = 64)
    protected String email;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    protected Role role;

}
