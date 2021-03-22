package com.my.grocery.controller;

import com.my.grocery.controller.base.dto.Response;
import com.my.grocery.controller.base.dto.Result;
import com.my.grocery.dto.recipe.RecipeRequestDto;
import com.my.grocery.dto.recipe.RecipeResponseDto;
import com.my.grocery.service.RecipeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    ResponseEntity<Response<RecipeResponseDto>> createRecipe(@RequestBody RecipeRequestDto req) {

        try {
            return ResponseEntity.ok(Response.ok(recipeService.createRecipe(req)));

        } catch (Exception ex) {
            return ResponseEntity.status(500).body((Response.exception(ex)));
        }
    }

    @GetMapping("/getAllRecipes")
    @ApiOperation(value = "Get List of Recipes")
    public @ResponseBody
    ResponseEntity<Response<List<RecipeResponseDto>>> getAllRecipes() {
        try {
            return ResponseEntity.ok(Response.ok(recipeService.getListOfRecipes()));

        } catch (Exception ex) {
            return ResponseEntity.status(500).body((Response.exception(ex)));
        }
    }

    @GetMapping("/getAllRecipesByUserId")
    @ApiOperation(value = "Get List of Recipes By User Id")
    public @ResponseBody
    ResponseEntity<Response<List<RecipeResponseDto>>> getRecipeByUserId(String userId) {
        try {
            return ResponseEntity.ok(Response.ok(recipeService.getListOfRecipesByUserId(userId)));

        } catch (Exception ex) {
            return ResponseEntity.status(500).body((Response.exception(ex)));
        }
    }

    // Get single recipe by Id
    @GetMapping("/getRecipesById")
    @ApiOperation(value = "Get Recipes By Id")
    public @ResponseBody
    ResponseEntity<Response<RecipeResponseDto>> getRecipeById(Long id) {
        try {
            return ResponseEntity.ok(Response.ok(recipeService.getRecipeById(id)));

        } catch (Exception ex) {
            return ResponseEntity.status(500).body((Response.exception(ex)));
        }
    }
    //update recipe
    @PutMapping(value = "/updateRecipe", produces = "application/json")
    @ApiOperation(value = "Update Recipe ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Updated Recipe successfully"),
            @ApiResponse(code = 406, message = "Json content not acceptable"),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    public @ResponseBody
    ResponseEntity<Response<RecipeResponseDto>> updateRecipe(@RequestBody RecipeRequestDto req,@RequestParam long recipeId) {

        try {
            return ResponseEntity.ok(Response.ok(recipeService.updateRecipe(req,recipeId)));

        } catch (Exception ex) {
            return ResponseEntity.status(500).body((Response.exception(ex)));
        }
    }

    @DeleteMapping(value = "/{id}/{userId}")
    @ApiOperation(value = "Delete Recipe")
    public ResponseEntity<Result<String>> deleteRecipe(@PathVariable long id, @PathVariable String userId) {

        if (id == 0l && userId == null)
            return ResponseEntity.status(500)
                    .body(new Result<>(new Exception("Recipe or userId is missing.")));
        try {
            recipeService.deleteRecipe(id, userId);
            return ResponseEntity.ok(new Result<>("Recipe deleted successfully"));
        } catch (Exception ex) {

            return ResponseEntity.status(500).body(new Result<>(ex));
        }

    }

}
