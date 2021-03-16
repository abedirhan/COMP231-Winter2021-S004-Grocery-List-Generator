package com.my.grocery.dto.ingredient;

import com.my.grocery.model.Ingredient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientResponseDto {

    private Long ingredientId;
    private String ingredientName;
    private String unitType;
    private String calorie;
    private String partyId;


    public IngredientResponseDto(Ingredient ingredient) {
        setIngredientId(ingredient.getIngredientId());
        setIngredientName(ingredient.getIngredientName());
        setUnitType(ingredient.getUnitType());
        setCalorie(ingredient.getCalorie());
        setPartyId(ingredient.getParty().getPartyId());

    }
}


