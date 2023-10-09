package org.joksin.springsociallogin.idms.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class SsoController {

    @SneakyThrows
    @GetMapping("/sso")
    public void home(@RequestParam String redirectTo, HttpSession httpSession, HttpServletResponse response) {
        log.info("Processing session ID: {}", httpSession.getId());

        log.info("Redirecting to: {}", redirectTo);

        var tokenCookie = new Cookie("idms-token", "TOKEN_VALUE_123");
        tokenCookie.setSecure(true);
        tokenCookie.setHttpOnly(true);

        response.addCookie(tokenCookie);

        response.sendRedirect(redirectTo);
    }

}
