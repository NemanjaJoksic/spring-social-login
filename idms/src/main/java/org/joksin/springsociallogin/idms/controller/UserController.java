package org.joksin.springsociallogin.idms.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @GetMapping("/me")
    public Object me(@RequestParam String token) {
        return "Token: " + token;
    }
}
