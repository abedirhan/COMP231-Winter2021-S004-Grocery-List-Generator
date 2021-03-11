package com.my.grocery.controller;

import com.my.grocery.controller.base.dto.Response;
import com.my.grocery.model.Party;
import com.my.grocery.service.PartyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/party")
@Api(tags = {"Party"}, description = "Party api")
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

    @GetMapping("/getGreetings")
    @ApiOperation(value = "Get greetings")
    public @ResponseBody
    String getGreeting() {

        return "Hello World";
    }
}
