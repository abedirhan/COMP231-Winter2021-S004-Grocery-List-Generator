package com.my.grocery.dto.recipe;

import com.my.grocery.model.Ingredient;
import com.my.grocery.model.RecipeItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeItemResponseDto {

    private Long itemId;
    private String itemQuantity;
    private Long ingredientId;
    private Long recipeId;
    private String ingredientName;
    private String unitType;
    private String calorie;

    public RecipeItemResponseDto(RecipeItem item) {
        setItemId(item.getItemId());
        setItemQuantity(item.getItemQuantity());
        setIngredientId(item.getIngredient().getIngredientId());
        setRecipeId(item.getRecipe().getRecipeId());
        setIngredientName(item.getIngredient().getIngredientName());
        setUnitType(item.getIngredient().getUnitType());
        setCalorie(item.getIngredient().getCalorie());
    }

}


