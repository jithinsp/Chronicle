package com.corner.accounts.service;

import com.corner.accounts.dto.CreateAccountTypeRequest;
import com.corner.accounts.entity.AccountType;
import com.corner.accounts.repository.AccountTypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeServiceImpl implements AccountTypeService{
    @Autowired
    AccountTypeRepository accountTypeRepository;

    public List<AccountType> getAllAccountTypes() {
        return accountTypeRepository.findAll();
    }

    public AccountType getAccountTypeById(Long id) {
        return accountTypeRepository.findById(id).orElseThrow();
    }

    public AccountType createAccountType(CreateAccountTypeRequest createAccountTypeRequest) {
        AccountType accountType = new AccountType();
        BeanUtils.copyProperties(createAccountTypeRequest,accountType);
        AccountType createdAccountType = accountTypeRepository.save(accountType);
        accountType.setId(createdAccountType.getId());
        return accountType;
    }

    public void deleteAccountTypeById(Long id) {
        accountTypeRepository.deleteById(id);
    }
}
