package com.corner.accounts.controller;

import com.corner.accounts.dto.CreateAccountTypeRequest;
import com.corner.accounts.entity.AccountType;
import com.corner.accounts.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("accounts/type")
public class TypeController {
    @Autowired
    AccountTypeService accountTypeService;
    @GetMapping("getAllAccountTypes")
    public ResponseEntity<?> getAccountType(){
        try {
            List<AccountType> accountTypes = accountTypeService.getAllAccountTypes();
            return ResponseEntity.ok(accountTypes);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("AccountType")
    public ResponseEntity<?> accountType(@RequestBody Map<String, Long> requestBody) {
        Long id = requestBody.get("id");
        try {
            AccountType accountType = accountTypeService.getAccountTypeById(id);
            return ResponseEntity.ok(accountType);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such Account Type found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("createAccountType")
    public ResponseEntity<?> createAccountType(@RequestBody CreateAccountTypeRequest createAccountTypeRequest){
        try{
            AccountType accountType = accountTypeService.createAccountType(createAccountTypeRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(accountType);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create type");
        }
    }

    @DeleteMapping("deleteAccountType/{id}")
    public ResponseEntity<String> deleteAccountType(@PathVariable Long id){
        try{
            accountTypeService.deleteAccountTypeById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such type found");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
