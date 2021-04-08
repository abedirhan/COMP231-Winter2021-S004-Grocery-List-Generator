package com.my.grocery.dto.recipe;

import com.my.grocery.model.Recipe;
import com.my.grocery.model.RecipeItem;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class RecipeDetailsResponseDto {

    private Long recipeId;
    private String recipeName;
    private String recipeDescription;
    private String recipePrice;
    private String recipePhoto;
    private List<Item> items = new ArrayList<>();

    public RecipeDetailsResponseDto(Recipe recipe) {
        this.recipeId = recipe.getRecipeId();
        this.recipeName = recipe.getRecipeName();
        this.recipeDescription = recipe.getDescription();
        this.recipePrice = recipe.getPrice();
        this.recipePhoto=recipe.getRecipePhoto();
        recipe.getItems().forEach(i -> items.add(new Item(i)));

    }
}

@Data
class ItemV1 {

    private String itemQuantity;
    private Long ingredientId;
    private String ingredientName;
    private String ingredientCalorie;
    private String ingredientUnitType;
    private String ingredientPartyId;

    public ItemV1(RecipeItem item) {
        this.itemQuantity = item.getItemQuantity();
        this.ingredientId = item.getIngredient().getIngredientId();
        this.ingredientName = item.getIngredient().getIngredientName();
        this.ingredientCalorie = item.getIngredient().getCalorie();
        this.ingredientUnitType = item.getIngredient().getUnitType();
        this.ingredientPartyId = item.getIngredient().getParty().getPartyId();
    }
}

