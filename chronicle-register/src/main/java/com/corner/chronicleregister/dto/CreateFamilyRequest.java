package com.corner.chronicleregister.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateFamilyRequest {
    private String houseName;
    private String area;
    private String place;
    private String district;
    private String state;
    private int postCode;
}
