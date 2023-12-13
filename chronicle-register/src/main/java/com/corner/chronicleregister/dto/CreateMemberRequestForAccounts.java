package com.corner.chronicleregister.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateMemberRequestForAccounts {
    private Long memberId;
    private String name;
    private Long familyId;
    private String houseName;
}
