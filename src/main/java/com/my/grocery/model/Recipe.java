package com.my.grocery.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "recipe", uniqueConstraints =  {@UniqueConstraint(columnNames =  {"recipe_id"})})

public class Recipe {
    @Id
    @Column(name = "recipe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long recipeId;

    @Basic(fetch = FetchType.EAGER, optional = true)
    @Column(name = "recipe_name", length = 64)
    @Length(max = 64)
    protected String recipeName;

    @Basic(fetch = FetchType.EAGER, optional = true)
    @Column(name = "description", length = 64)
    @Length(max = 1500)
    protected String description;

    @Basic(fetch = FetchType.EAGER, optional = true)
    @Column(name = "price", length = 64)
    @Length(max = 64)
    protected String price;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = true)
    @Column(name = "recipe_photo")
    @Length(max = 1500)
    protected String recipePhoto;

    @OneToMany(targetEntity = RecipeItem.class, cascade =  {
            CascadeType.ALL}
            , fetch = FetchType.EAGER,orphanRemoval = true)
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
    protected List<RecipeItem> items;

    @ManyToOne(targetEntity = Party.class, cascade =  {
            CascadeType.PERSIST, CascadeType.MERGE}
            , fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "party_id", referencedColumnName = "party_id")
    @Cascade(value =  {
            org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST}
    )
    protected Party party;


    public void addRecipeItem(RecipeItem recipeItem){
        this.items = items == null ? new ArrayList<>(): items;
        recipeItem.setRecipe(this);
        items.add(recipeItem);
    }
}
