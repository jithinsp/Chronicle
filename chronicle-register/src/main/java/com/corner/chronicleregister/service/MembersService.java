package com.corner.chronicleregister.service;

import com.corner.chronicleregister.dto.CreateMemberRequest;
import com.corner.chronicleregister.entity.Members;

import java.util.List;

public interface MembersService {
    List<Members> getAllMembers();

    Members getMemberById(Long id);

    Members createMember(CreateMemberRequest createMemberRequest);

    void deleteMemberById(Long id);
}
