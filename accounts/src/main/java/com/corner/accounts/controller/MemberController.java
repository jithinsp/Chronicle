package com.corner.accounts.controller;

import com.corner.accounts.dto.CreateAccountTypeRequest;
import com.corner.accounts.dto.CreateMemberRequest;
import com.corner.accounts.entity.AccountType;
import com.corner.accounts.entity.Members;
import com.corner.accounts.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("accounts/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("getMembers")
    public ResponseEntity<?> getMembers(){
        try {
            List<Members> memberList = memberService.getAllMembers();
            return ResponseEntity.ok(memberList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping("getMember")
    public ResponseEntity<?> getMember(@RequestBody Map<String, Long> requestBody) {
        Long id = requestBody.get("id");
        try {
            Members member = memberService.getMemberById(id);
            return ResponseEntity.ok(member);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such member found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping("createMember")
    public ResponseEntity<?> createMember(@RequestBody CreateMemberRequest createMemberRequest){
        try{
            Members member = memberService.createMember(createMemberRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(member);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create member");
        }
    }


    @DeleteMapping("deleteMember/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id){
        try{
            System.out.println("Delete id: "+id);
            memberService.deleteMemberById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such member found");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}