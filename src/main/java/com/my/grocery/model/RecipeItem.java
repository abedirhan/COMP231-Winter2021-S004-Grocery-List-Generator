package com.my.grocery.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@BatchSize(size = 10)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@FilterDef(name = "deletedEntityFilter")
@Filters({@Filter(name = "deletedEntityFilter", condition = "deleted <> 1")
})
@Table(name = "recipe_item", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"item_id"})})
@DiscriminatorValue("recipe")
public class RecipeItem {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long itemId;

    @ManyToOne(targetEntity = Recipe.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
    protected Recipe recipe;

    @Basic(fetch = FetchType.EAGER, optional = true)
    @Column(name = "item_quantity", length = 64)
    protected String itemQuantity;

    // icerik onceden olusturuluyor
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id")
    protected Ingredient ingredient;


}
