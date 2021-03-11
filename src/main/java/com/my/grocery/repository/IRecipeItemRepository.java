package com.my.grocery.repository;

import com.my.grocery.model.RecipeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecipeItemRepository extends JpaRepository<RecipeItem, Long> {
}
