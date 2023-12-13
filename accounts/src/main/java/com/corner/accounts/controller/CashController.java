package com.corner.accounts.controller;

import com.corner.accounts.dto.CreateCashRequest;
import com.corner.accounts.dto.CreateMemberRequest;
import com.corner.accounts.entity.Cash;
import com.corner.accounts.entity.Members;
import com.corner.accounts.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("accounts/cash")
public class CashController {
    @Autowired
    CashService cashService;

    @GetMapping("getAllCash")
    public ResponseEntity<?> getAllCash(){
        try {
            List<Cash> cash = cashService.getAllCash();
            return ResponseEntity.ok(cash);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping("getCash")
    public ResponseEntity<?> getCash(@RequestBody Map<String, Long> requestBody) {
        Long id = requestBody.get("id");
        try {
            Cash cash = cashService.getCashById(id);
            return ResponseEntity.ok(cash);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such cash found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping("createCash")
    public ResponseEntity<?> createCash(@RequestBody CreateCashRequest createCashRequest){
        try{
            Cash cash = cashService.createCash(createCashRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(cash);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create cash");
        }
    }


    @DeleteMapping("deleteCash/{id}")
    public ResponseEntity<String> deleteCash(@PathVariable Long id){
        try{
            cashService.deleteCashById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such cash found");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
