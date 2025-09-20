package com.projectnexus.controller;

import com.projectnexus.dto.AuthResponse;
import com.projectnexus.dto.UserDto;
import com.projectnexus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/user")
    public UserDto getCurrentUser(Principal principal) {
        return userService.getCurrentUser(principal.getName());
    }

    @GetMapping("/oauth2/user")
    public AuthResponse oauth2Login(@AuthenticationPrincipal OAuth2User principal) {
        String username = principal.getAttribute("email");
        UserDto user = userService.getCurrentUser(username);

        // In a real implementation, you would generate a token
        return new AuthResponse("oauth2-token", 3600L, user);
    }
}