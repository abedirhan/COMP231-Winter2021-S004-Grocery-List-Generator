package com.my.grocery.controller;

import com.my.grocery.controller.base.dto.Response;
import com.my.grocery.dto.ingredient.IngredientRequestDto;
import com.my.grocery.dto.ingredient.IngredientResponseDto;
import com.my.grocery.service.IngredientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @PostMapping(produces = "application/json")
    @ApiOperation(value = "Create New Ingredient ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Added New Ingredient successfully"),
            @ApiResponse(code = 406, message = "Json content not acceptable"),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    public @ResponseBody
    ResponseEntity<Response<IngredientResponseDto>> createIngredient(@RequestBody IngredientRequestDto req) {

        try {
            return ResponseEntity.ok(Response.ok(ingredientService.createIngredient(req)));

        } catch (Exception ex) {
            return ResponseEntity.status(500).body((Response.exception(ex)));
        }
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "Get List of Ingredients ")
    public @ResponseBody
    ResponseEntity<Response<List<IngredientResponseDto>>> getIngredients() {

        try {
            return ResponseEntity.ok(Response.ok(ingredientService.getListOfIngredients()));

        } catch (Exception ex) {
            return ResponseEntity.status(500).body((Response.exception(ex)));
        }
    }

    @GetMapping("/getByName")
    @ApiOperation(value = "Get Ingredients by Name ")
    public @ResponseBody
    ResponseEntity<Response<List<IngredientResponseDto>>> getIngredientByName(@RequestParam String name) {

        try {
            return ResponseEntity.ok(Response.ok(ingredientService.getIngredientbyName(name)));

        } catch (Exception ex) {
            return ResponseEntity.status(500).body((Response.exception(ex)));
        }
    }

}
