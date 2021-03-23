package com.my.grocery.repository;

import com.my.grocery.dto.recipe.GroceryResponseDto;
import com.my.grocery.model.Recipe;
import com.my.grocery.model.RecipeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface IRecipeRepository extends JpaRepository<Recipe, Long> {
    @Query(value = " select * from recipe where party_id =?1 ", nativeQuery = true)
    List<Recipe> getRecipeByUserId(String userId);

   @Query(value = " select                  " +
           " recipe_item.item_id as itemId,                                                    " +
           " recipe_item.item_quantity as itemQuantity,                                        " +
           " recipe_item.ingredient_id as ingredientId,                                        " +
           " ingredient.ingredient_name as ingredientName,                                     " +
           " ingredient.calorie as ingredientCalorie,                                          " +
           " ingredient.unit_type as ingredientUnitType,                                       " +
           " ingredient.party_id as ingredientPartyId                                         " +
           " From                                                                              " +
           " recipe_item                                                                       " +
           " Join ingredient on recipe_item.ingredient_id = ingredient.ingredient_id           " +
           " where recipe_id=?1 ", nativeQuery = true)
   List<Tuple> getGroceryList(Long recipeId);

}
