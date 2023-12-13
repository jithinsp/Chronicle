package com.corner.accounts.service;

import com.corner.accounts.dto.CreateMemberRequest;
import com.corner.accounts.entity.Members;
import com.corner.accounts.repository.MemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberRepository memberRepository;

    public List<Members> getAllMembers() {
        return memberRepository.findAll();
    }

    public Members getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow();
    }

    public Members createMember(CreateMemberRequest createMemberRequest) {
        Members member = new Members();
        BeanUtils.copyProperties(createMemberRequest,member);
        return memberRepository.save(member);
    }

    public void deleteMemberById(Long id) {
        memberRepository.deleteById(id);
    }
}
