package com.my.grocery.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "recipe_item", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"item_id"})})
@DiscriminatorValue("recipe")
public class RecipeItem {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long itemId;

    @ManyToOne(targetEntity = Recipe.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
    protected Recipe recipe;

    @Basic(fetch = FetchType.EAGER, optional = true)
    @Column(name = "item_quantity", length = 64)
    protected String itemQuantity;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id")
    protected Ingredient ingredient;


}
