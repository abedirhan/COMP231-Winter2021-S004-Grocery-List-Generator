package com.my.grocery.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@BatchSize(size = 10)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@FilterDef(name = "deletedEntityFilter")
@Filters({@Filter(name = "deletedEntityFilter",condition = "deleted <> 1")})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@javax.persistence.Table(name = "recipe_item", uniqueConstraints =  {@UniqueConstraint(columnNames =  {"item_id"})})
public class RecipeItem {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long itemId;

    @Basic(fetch = FetchType.EAGER, optional = true)
    @Column(name = "item_quantity", length = 64)
    @Length(max = 64)
    protected String itemQuantity;

    @ManyToOne(targetEntity = Ingredient.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id", insertable = false, updatable = false)
    @NotNull
    protected Ingredient ingredient;

    @ManyToOne(targetEntity = Recipe.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id", insertable = false, updatable = false)
    @NotNull
    protected Recipe recipe;
}
