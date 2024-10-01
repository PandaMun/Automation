package com.taehomun.automation_server.service;

import com.taehomun.automation_server.dto.MemberDto;
import com.taehomun.automation_server.dto.MemberRes;
import com.taehomun.automation_server.entity.Member;
import com.taehomun.automation_server.entity.Role;
import com.taehomun.automation_server.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void createMember(MemberDto member) {
        memberRepository.save(
                Member.builder()
                        .email(member.getEmail())
                        .password(passwordEncoder.encode(member.getPassword()))
                        .phone(member.getPhone())
                        .role(Role.USER)
                        .username(member.getUsername())
                        .build()
        );
    }

    @Override
    public void updateMember(MemberDto memberDto) {
        Member member = memberRepository.findByEmail(memberDto.getEmail()).get();
        member.updateInfo(memberDto.getUsername(), memberDto.getEmail(), memberDto.getPhone(), memberDto.getAddress());
        memberRepository.save(member);
    }

    @Override
    public void deleteMember(MemberDto member) {

    }

    @Override
    public List<MemberDto> getMembers() {
        return List.of();
    }

    @Override
    public MemberDto getMemberById(Long id) {
        return null;
    }
}
