package org.joksin.springsociallogin.idms.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Slf4j
@Controller
@AllArgsConstructor
public class TokenController {

    @SneakyThrows
    @GetMapping("/token")
    public void token(@RequestParam String redirectTo, HttpSession httpSession,
                      HttpServletResponse response, @AuthenticationPrincipal OAuth2User user) {
        var token = httpSession.getAttribute("token");
        if (token == null) {
            token = generateToken(user);
            httpSession.setAttribute("token", token);
            log.info("Token stored to session");
        } else {
            log.info("Token already stored in session");
        }

        redirectTo = redirectTo + "?token=" + token;
        log.info("Redirecting to: {}", redirectTo);
        response.sendRedirect(redirectTo);
    }

    private String generateToken(OAuth2User user) {
        return UUID.randomUUID().toString();
    }
}
