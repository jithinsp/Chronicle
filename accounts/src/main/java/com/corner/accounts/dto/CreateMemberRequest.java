package com.corner.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateMemberRequest {
    private Long memberId;
    private String name;
    private Long familyId;
    private String houseName;
}
