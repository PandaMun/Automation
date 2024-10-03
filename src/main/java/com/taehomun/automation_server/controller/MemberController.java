package com.taehomun.automation_server.controller;


import com.taehomun.automation_server.dto.MemberDto;
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
    public ResponseEntity registerMember(@RequestBody MemberDto member) {

        try{
            memberService.createMember(member);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();

    }

    @PostMapping("/update")
    public ResponseEntity updateMember(@RequestBody MemberDto member) {
        try{
            memberService.updateMember(member);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
}
