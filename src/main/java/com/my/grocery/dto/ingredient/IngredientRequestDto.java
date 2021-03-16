package com.my.grocery.dto.ingredient;

import com.my.grocery.model.Ingredient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientRequestDto {


    private String ingredientName;
    private String unitType;
    private String calorie;
    private String partyId;


    public IngredientRequestDto(Ingredient ingredient) {
        setIngredientName(ingredient.getIngredientName());
        setUnitType(ingredient.getUnitType());
        setCalorie(ingredient.getCalorie());
        setPartyId(ingredient.getParty().getPartyId());

    }
}


