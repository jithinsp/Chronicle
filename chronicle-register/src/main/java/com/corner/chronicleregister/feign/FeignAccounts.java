package com.corner.chronicleregister.feign;

import com.corner.chronicleregister.dto.CreateMemberRequestForAccounts;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("CHRONICLE-ACCOUNTS")
public interface FeignAccounts {
    @PostMapping("accounts/member/createMember")
    public ResponseEntity<?> createMember(@RequestBody CreateMemberRequestForAccounts createMemberRequestForAccounts);
}
