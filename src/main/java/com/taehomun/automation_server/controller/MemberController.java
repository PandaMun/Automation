package com.taehomun.automation_server.controller;


import com.taehomun.automation_server.dto.MemberDto;
import com.taehomun.automation_server.dto.ResponseDto;
import com.taehomun.automation_server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/regist")
    public ResponseDto registerMember(@RequestBody MemberDto member) {

        try{
            memberService.createMember(member);
        }catch (Exception e) {
            return ResponseDto.builder()
                    .message("회원등록에 실패하였습니다.")
                    .status("Fail")
                    .build();
        }
        return ResponseDto.builder()
                .status("Success")
                .message("회원등록에 성공하였습니다.")
                .build();

    }

    @PostMapping("/update")
    public ResponseDto updateMember(@RequestBody MemberDto member) {
        try{
            memberService.updateMember(member);
        }catch (Exception e) {
            return ResponseDto.builder()
                    .message("회원등록에 실패하였습니다.")
                    .status("Fail")
                    .build();
        }
        return ResponseDto.builder()
                .status("Success")
                .message("회원등록에 성공하였습니다.")
                .build();
    }
}
