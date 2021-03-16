package com.my.grocery.dto.party;

import com.my.grocery.model.Party;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartyDto {

    private String userId;

    public PartyDto(Party item) {
        setUserId(item.getPartyId());

    }
}
