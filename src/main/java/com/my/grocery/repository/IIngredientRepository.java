package com.my.grocery.repository;

import com.my.grocery.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIngredientRepository extends JpaRepository<Ingredient, Long> {
    @Query(value = " select * from ingredient where ingredient.ingredient_name LIKE ?% ", nativeQuery = true)
    List<Ingredient> findByName(String name);

    @Query(value = " select * from ingredient where ingredient.party_id=?1 ", nativeQuery = true)
    List<Ingredient> findByNameUserId(String userId);
}
