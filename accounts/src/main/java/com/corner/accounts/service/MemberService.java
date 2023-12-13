package com.corner.accounts.service;

import com.corner.accounts.dto.CreateMemberRequest;
import com.corner.accounts.entity.Members;

import java.util.List;

public interface MemberService {
    List<Members> getAllMembers();

    Members getMemberById(Long id);

    Members createMember(CreateMemberRequest createMemberRequest);

    void deleteMemberById(Long id);
}
