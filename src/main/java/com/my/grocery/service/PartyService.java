package com.my.grocery.service;

import com.my.grocery.dto.party.PartyDto;
import com.my.grocery.model.Party;
import com.my.grocery.repository.IPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PartyService {
    @Autowired
    private IPartyRepository partyRepository;

    public List<Party> getAllMembers() {
       List<Party> parties;
       parties=partyRepository.findAll();

      return parties;
    }
    public PartyDto createUser(String userId) {

        Party newUser = new Party();
        newUser.setPartyId(userId);
        partyRepository.save(newUser);
        PartyDto dto = new PartyDto();
        dto.setUserId(userId);
        return dto;
    }

}
