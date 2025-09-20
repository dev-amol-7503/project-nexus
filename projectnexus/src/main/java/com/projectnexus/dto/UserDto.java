package com.projectnexus.dto;

import com.projectnexus.model.User;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private User.UserStatus status;
}