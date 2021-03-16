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

@Getter
@Setter
@NoArgsConstructor
@Entity
@javax.persistence.Table(name = "ingredient", uniqueConstraints =  {@UniqueConstraint(columnNames =  {"ingredient_id"})})
public class Ingredient {
    @Id
    @Column(name = "ingredient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long ingredientId;

    @Basic(fetch = FetchType.EAGER, optional = true)
    @Column(name = "ingredient_name", length = 64)
    @Length(max = 64)
    protected String ingredientName;

    @Basic(fetch = FetchType.EAGER, optional = true)
    @Column(name = "unit_type", length = 64)
    @Length(max = 64)
    protected String unitType;

    @Basic(fetch = FetchType.EAGER, optional = true)
    @Column(name = "calorie", length = 64)
    @Length(max = 64)
    protected String calorie;

    @ManyToOne(targetEntity = Party.class, cascade =  {
            CascadeType.PERSIST, CascadeType.MERGE}
            , fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "party_id", referencedColumnName = "party_id")
    @Cascade(value =  {
            org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST}
    )
    protected Party party;

}
