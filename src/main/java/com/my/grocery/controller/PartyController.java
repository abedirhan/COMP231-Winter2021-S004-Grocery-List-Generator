package com.my.grocery.controller;

import com.my.grocery.controller.base.dto.Response;
import com.my.grocery.dto.party.PartyDto;
import com.my.grocery.dto.recipe.RecipeRequestDto;
import com.my.grocery.dto.recipe.RecipeResponseDto;
import com.my.grocery.model.Party;
import com.my.grocery.service.PartyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/party")
public class PartyController {
    @Autowired
    private PartyService partyService;

    @GetMapping("/getAllMembers")
    @ApiOperation(value = "Get All Members")
    public @ResponseBody
    ResponseEntity<Response<List<Party>>> getAllMembers() {

        try {
            return ResponseEntity.ok(Response.ok(partyService.getAllMembers()));
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(Response.exception(ex));
        }
    }
    @PostMapping(produces = "application/json")
    @ApiOperation(value = "Create User ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Added New User successfully"),
            @ApiResponse(code = 406, message = "Json content not acceptable"),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    public @ResponseBody
    ResponseEntity<Response<PartyDto>> createUser(@RequestParam String id) {

        try {
            return ResponseEntity.ok(Response.ok(partyService.createUser(id)));

        } catch (Exception ex) {
            return ResponseEntity.status(500).body((Response.exception(ex)));
        }
    }

}
