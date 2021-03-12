package com.my.grocery.service;

import com.my.grocery.dto.ingredient.IngredientRequestDto;
import com.my.grocery.dto.ingredient.IngredientResponseDto;
import com.my.grocery.model.Ingredient;
import com.my.grocery.model.Party;
import com.my.grocery.repository.IIngredientRepository;
import com.my.grocery.repository.IPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class IngredientService {
    @Autowired
    private IPartyRepository partyRepository;
    @Autowired
    private IIngredientRepository ingredientRepository;
    public IngredientResponseDto createIngredient(IngredientRequestDto req){
        Assert.notNull(req.getIngredientName(), "Ingredient name is required.");
        Assert.notNull(req.getPartyId(), "Party Id is required.");
        Assert.notNull(req.getUnitType(), "Unit Type Id is required.");
        Assert.notNull(req.getCalorie(), "Calorie is required.");
        Optional<Party> party = partyRepository.findById(req.getPartyId());
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(req.getIngredientName());
        ingredient.setCalorie(req.getCalorie());
        ingredient.setUnitType(req.getUnitType());
        ingredient.setParty(party.get());

        ingredientRepository.save(ingredient);
        return new IngredientResponseDto(ingredient);
    }
}
