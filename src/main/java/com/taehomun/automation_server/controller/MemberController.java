package com.taehomun.automation_server.controller;


import com.taehomun.automation_server.dto.MemberDto;
import com.taehomun.automation_server.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/regist")
    public ResponseEntity registerMember(@RequestBody MemberDto member) {

        try{
            memberService.createMember(member);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();

    }

}
