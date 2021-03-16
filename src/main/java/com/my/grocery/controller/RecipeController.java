package com.my.grocery.controller;

import com.my.grocery.controller.base.dto.Response;
import com.my.grocery.controller.base.dto.Result;
import com.my.grocery.dto.ingredient.IngredientResponseDto;
import com.my.grocery.dto.recipe.RecipeRequestDto;
import com.my.grocery.dto.recipe.RecipeResponseDto;
import com.my.grocery.service.RecipeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @PostMapping(produces = "application/json")
    @ApiOperation(value = "Create New Recipe ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Added New Recipe successfully"),
            @ApiResponse(code = 406, message = "Json content not acceptable"),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    public @ResponseBody
    ResponseEntity<Response<RecipeResponseDto>> createIngredient(@RequestBody RecipeRequestDto req) {

        try {
            return ResponseEntity.ok(Response.ok(recipeService.createRecipe(req)));

        } catch (Exception ex) {
            return ResponseEntity.status(500).body((Response.exception(ex)));
        }
    }
    @GetMapping("/getAllRecipes")
    @ApiOperation(value = "Get List of Recipes")
    public @ResponseBody
    ResponseEntity<Response<List<RecipeResponseDto>>> getIngredients() {
        try {
            return ResponseEntity.ok(Response.ok(recipeService.getListOfRecipes()));

        } catch (Exception ex) {
            return ResponseEntity.status(500).body((Response.exception(ex)));
        }
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete Recipe")
    public ResponseEntity<Result<String>> deleteUnmatchedLabReport(@PathVariable long id) {

        if (id == 0L)
            return ResponseEntity.status(500)
                    .body(new Result<>(new Exception("Recipe Id is missing.")));
        try {
            recipeService.deleteRecipe(id);
            return ResponseEntity.ok(new Result<>("Recipe deleted successfully"));
        } catch (Exception ex) {

            return ResponseEntity.status(500).body(new Result<>(ex));
        }

    }

}
