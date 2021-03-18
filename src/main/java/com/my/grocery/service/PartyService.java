package com.my.grocery.service;

import com.my.grocery.dto.party.PartyDto;
import com.my.grocery.dto.party.PartyRequestDto;
import com.my.grocery.model.Party;
import com.my.grocery.model.Role;
import com.my.grocery.repository.IPartyRepository;
import com.my.grocery.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


import java.util.List;
import java.util.Optional;

@Service
public class PartyService {
    @Autowired
    private IPartyRepository partyRepository;
    @Autowired
    private IRoleRepository roleRepository;

    public List<Party> getAllMembers() {
       List<Party> parties;
       parties=partyRepository.findAll();

      return parties;
    }
    public PartyDto createUser(PartyRequestDto req) {
        System.out.println("POST service RECEIVED");
        Party newUser = new Party();
        Assert.notNull(req.getUserId(), "User id is required.");
        Assert.notNull(req.getRole(), "Role id is required.");
        newUser.setPartyId(req.getUserId());
        Optional<Role> role= roleRepository.findById(req.getRole());
        newUser.setRole(role.get());
        partyRepository.save(newUser);
        PartyDto dto = new PartyDto();
        dto.setUserId(req.getUserId());
        dto.setRole(req.getRole());
        return dto;
    }

}
