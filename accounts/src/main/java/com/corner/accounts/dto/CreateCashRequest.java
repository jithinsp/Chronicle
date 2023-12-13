package com.corner.accounts.dto;

import com.corner.accounts.entity.AccountType;
import com.corner.accounts.entity.Members;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class CreateCashRequest {
    private double amount;
    private Date date;
    private Members members;
    private AccountType accountType;

}
