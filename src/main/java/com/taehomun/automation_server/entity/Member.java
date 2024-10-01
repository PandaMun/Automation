package com.taehomun.automation_server.entity;

import com.taehomun.automation_server.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public void updateInfo(String newUsername, String newEmail, String newPhone, String newAddress) {
        this.username = newUsername;
        this.email = newEmail;
        this.phone = newPhone;
        this.address = newAddress;
    }
    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

}