package com.corner.accounts.service;

import com.corner.accounts.dto.CreateAccountTypeRequest;
import com.corner.accounts.entity.AccountType;

import java.util.List;

public interface AccountTypeService {
    List<AccountType> getAllAccountTypes();

    AccountType getAccountTypeById(Long id);

    AccountType createAccountType(CreateAccountTypeRequest createAccountTypeRequest);

    void deleteAccountTypeById(Long id);
}
