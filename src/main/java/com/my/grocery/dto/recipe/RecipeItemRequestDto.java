package com.my.grocery.dto.recipe;

import com.my.grocery.model.Ingredient;
import com.my.grocery.model.RecipeItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeItemRequestDto {

    private String itemQuantity;
    private Long ingredientId;


    public RecipeItemRequestDto(RecipeItem item) {
        setItemQuantity(item.getItemQuantity());
        setIngredientId(item.getIngredient().getIngredientId());


    }
}


