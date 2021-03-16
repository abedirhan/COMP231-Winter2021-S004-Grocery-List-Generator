package com.my.grocery.repository;

import com.my.grocery.model.Ingredient;
import com.my.grocery.model.RecipeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecipeItemRepository extends JpaRepository<RecipeItem, Long> {
    @Query(value = " select * from recipe_item where recipe_item.recipe_id =?1 ", nativeQuery = true)
    List<RecipeItem> getRecipeItemList(Long id);

    @Query(value = " select item_id from recipe_item where recipe_id =?1 ", nativeQuery = true)
    List<Long> getRecipeItemId(Long id);

    @Query(value = " select * from recipe_item where recipe_id =?1 ", nativeQuery = true)
    List<RecipeItem> getRecipeItemByRecipeId(Long id);

}
