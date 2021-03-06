package com.my.grocery.dto.party;

import com.my.grocery.model.Party;
import com.my.grocery.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartyDto {

    private String userId;
    private Long role;

    public PartyDto(Party item) {
        setUserId(item.getPartyId());
        setRole(item.getRole().getRoleId());

    }
}
