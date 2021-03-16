package com.my.grocery.dto.recipe;

import com.my.grocery.model.Ingredient;
import com.my.grocery.model.Recipe;
import com.my.grocery.model.RecipeItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class RecipeResponseDto {

    private Long recipeId;
    private String recipeName;
    private Byte[] recipePhoto;
    private String partyId;

    List<RecipeItemResponseDto> recipeItemList =new ArrayList<>();


    public RecipeResponseDto(Recipe recipe, List<RecipeItemResponseDto> _recipeItemList ) {
        setRecipeId(recipe.getRecipeId());
        setRecipeName(recipe.getRecipeName());
        setRecipePhoto(recipe.getRecipePhoto());
        setPartyId(recipe.getParty().getPartyId());
        setRecipeItemList(_recipeItemList);





//        recipe.getItems().forEach((RecipeItem)recipeItem ->{
//            if (recipeItem instanceof RecipeItem) {
//                recipeItemList.add(new RecipeItemResponseDto((RecipeItem) recipeItem));
//            }
//        });

   //    recipeItemList.addAll(_recipeItemList.stream().map( inputMethod ->new RecipeItemResponseDto (inputMethod) ).collect(Collectors.toList()));

    }
}


