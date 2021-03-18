package com.my.grocery.dto.party;

import com.my.grocery.model.Party;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartyRequestDto {

    private String userId;
    private Long role;

    public PartyRequestDto(Party party) {
        setUserId(party.getPartyId());
        setRole(party.getRole().getRoleId());

    }
}
