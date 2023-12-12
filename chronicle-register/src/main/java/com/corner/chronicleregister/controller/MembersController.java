package com.corner.chronicleregister.controller;

import com.corner.chronicleregister.dto.CreateMemberRequest;
import com.corner.chronicleregister.entity.Members;
import com.corner.chronicleregister.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("register/members")
public class MembersController {
    @Autowired
    MembersService membersService;

    //API tested in postman and working
    @GetMapping("getMembers")
    public ResponseEntity<?> getMembers(){
        try {
            List<Members> memberList = membersService.getAllMembers();
            return ResponseEntity.ok(memberList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //API tested in postman and working
    @PostMapping("getMember")
    public ResponseEntity<?> getMember(@RequestBody Map<String, Long> requestBody) {
        Long id = requestBody.get("id");
        try {
            Members member = membersService.getMemberById(id);
            return ResponseEntity.ok(member);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such member found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //API tested in postman and working
    @PostMapping("createMember")
    public ResponseEntity<?> createFamily(@RequestBody CreateMemberRequest createMemberRequest){
        try{
            Members member = membersService.createMember(createMemberRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(member);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create member");
        }
    }

    //API tested in postman and working
    @DeleteMapping("deleteMember/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id){
        try{
            System.out.println("Delete id: "+id);
            membersService.deleteMemberById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such member found");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
