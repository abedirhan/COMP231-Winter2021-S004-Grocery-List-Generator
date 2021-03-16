package com.my.grocery.dto.recipe;


import com.my.grocery.model.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RecipeRequestDto {


    private String recipeName;
    private String description;
    private String price;
    private Byte[] recipePhoto;
    private String partyId;

    List<RecipeItemRequestDto> recipeItemList = new ArrayList<>();


    public RecipeRequestDto(Recipe recipe) {

        setRecipeName(recipe.getRecipeName());
        setPrice(recipe.getPrice());
        setDescription(recipe.getDescription());
        setRecipePhoto(recipe.getRecipePhoto());
        setPartyId(recipe.getParty().getPartyId());

    }
}


