package com.corner.chronicleregister.service;

import com.corner.chronicleregister.dto.CreateMemberRequest;
import com.corner.chronicleregister.entity.Members;
import com.corner.chronicleregister.repository.MembersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembersServiceImpl implements MembersService{
    @Autowired
    MembersRepository membersRepository;

    public List<Members> getAllMembers() {
        return membersRepository.findAll();
    }

    public Members getMemberById(Long id) {
        return membersRepository.findById(id).orElseThrow();
    }

    public Members createMember(CreateMemberRequest createMemberRequest) {
        Members members = new Members();
        BeanUtils.copyProperties(createMemberRequest, members);
        Members createdMember = membersRepository.save(members);
        members.setId(createdMember.getId());
        return members;
    }

    public void deleteMemberById(Long id) {
        membersRepository.deleteById(id);
    }
}
