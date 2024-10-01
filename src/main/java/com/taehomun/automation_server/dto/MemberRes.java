package com.taehomun.automation_server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MemberRes {
    private int id;
    private String name;
    private String email;
    private String phone;

}
