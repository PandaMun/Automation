package com.taehomun.automation_server.dto;


import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class ResponseDto {

    String message;
    String status;
    Object data;
}
