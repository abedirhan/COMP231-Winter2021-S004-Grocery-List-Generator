package com.my.grocery.controler;

import com.my.grocery.service.PartyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/party")
@Api(tags = {"Party"}, description = "Party api")
public class PartyController {
    @Autowired
    private PartyService partyService;

}
