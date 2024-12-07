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

@Slf4j
@Controller
@AllArgsConstructor
public class SsoController {

    @SneakyThrows
    @GetMapping("/sso")
    public void home(@RequestParam String redirectTo, HttpSession session, HttpServletResponse response,
                     @AuthenticationPrincipal OAuth2User user) {
        log.info("Processing session ID: {}", session.getId());
        log.info("Redirecting to: {}", redirectTo);

        session.setAttribute("user", user.getAttributes());

        response.sendRedirect(redirectTo);
    }

}
