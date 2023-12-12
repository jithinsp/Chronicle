package com.corner.chronicleregister.dto;
import com.corner.chronicleregister.entity.Family;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CreateMemberRequest {
    private String name;
    private int phone;
    private String email;
    private Date dateOfBirth;
    private Family family;
}
