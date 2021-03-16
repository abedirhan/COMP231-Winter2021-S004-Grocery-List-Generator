package com.my.grocery.repository;

import com.my.grocery.model.Party;
import com.my.grocery.model.Recipe;
import com.my.grocery.model.RecipeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPartyRepository extends JpaRepository<Party,Long> {
    @Query(value = " select * from party where party_id =?1 ", nativeQuery = true)
    Party findById(String id);
}
