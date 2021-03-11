package com.my.grocery.repository;

import com.my.grocery.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceipeRepository extends JpaRepository<Recipe,Long> {
}
