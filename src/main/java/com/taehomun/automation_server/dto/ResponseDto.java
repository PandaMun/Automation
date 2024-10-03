package com.taehomun.automation_server.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ResponseDto {

    String message;
    String status;
    Object data;
}
