package com.taehomun.automation_server.service;

import com.taehomun.automation_server.dto.MemberDto;
import com.taehomun.automation_server.dto.MemberRes;

import java.util.List;
import java.util.Map;

public interface MemberService {

    void createMember(MemberDto member);
    void updateMember(MemberDto member);
    void deleteMember(MemberDto member);
    List<MemberDto> getMembers();
    MemberDto getMemberById(Long id);

}
