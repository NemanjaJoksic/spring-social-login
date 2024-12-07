package org.joksin.springsociallogin.idms.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@AllArgsConstructor
public class SsoController {

    @SneakyThrows
    @GetMapping("/sso")
    public void home(@RequestParam String redirectTo, HttpServletResponse response) {
        log.info("Redirecting to: {}", redirectTo);
        response.sendRedirect(redirectTo);
    }

    @SneakyThrows
    @GetMapping("/token")
    public void token(@RequestParam String redirectTo, HttpServletResponse response, @AuthenticationPrincipal OAuth2User user) {
        redirectTo = redirectTo + "?token=" + user.getAttribute("email");
        log.info("Redirecting to: {}", redirectTo);
        response.sendRedirect(redirectTo);
    }

}
