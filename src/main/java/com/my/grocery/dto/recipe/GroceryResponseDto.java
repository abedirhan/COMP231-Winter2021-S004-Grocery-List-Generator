package com.my.grocery.dto.recipe;

import com.my.grocery.model.Recipe;
import com.my.grocery.model.RecipeItem;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class GroceryResponseDto {

    private Long recipeId;
    private List<Item> items = new ArrayList<>();

    public GroceryResponseDto(Recipe recipe) {
        this.recipeId = recipe.getRecipeId();
        recipe.getItems().forEach(i-> items.add(new Item(i)));

    }

}


@Data
class Item{

    private String itemQuantity;
    private Long ingredientId;
    private String ingredientName;
    private String ingredientCalorie;
    private String ingredientUnitType;
    private String ingredientPartyId;

    public Item(RecipeItem item){
        this.itemQuantity = item.getItemQuantity();
        this.ingredientId = item.getIngredient().getIngredientId();
        this.ingredientName =  item.getIngredient().getIngredientName();
        this.ingredientCalorie =  item.getIngredient().getCalorie();
        this.ingredientUnitType =  item.getIngredient().getUnitType();
        this.ingredientPartyId =  item.getIngredient().getParty().getPartyId();
    }
}

