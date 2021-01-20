package com.myepark.study.model.network.response;

import com.myepark.study.model.enumclass.AdminUserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminUserApiResponse {

    private Long id;

    private String account;

    private String password;

    private AdminUserStatus status;

    private String role;

    private LocalDateTime lastLoginAt;

    private int loginFailCount;

    private LocalDateTime passwordUpdatedAt;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;
}