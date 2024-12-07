package org.joksin.springsociallogin.idms.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @GetMapping("/api/users/me")
    public Object getMe(HttpSession session) {
        log.info("Fetching user data from session [ID: {}]", session.getId());
        return session.getAttribute("user");
    }
}
