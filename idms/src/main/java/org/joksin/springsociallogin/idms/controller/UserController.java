package org.joksin.springsociallogin.idms.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @GetMapping("/api/users/me")
    public Object getMe(@AuthenticationPrincipal OAuth2User user) {
        return user.getAttributes();
    }
}
