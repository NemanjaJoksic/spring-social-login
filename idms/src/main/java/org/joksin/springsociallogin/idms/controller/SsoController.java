package org.joksin.springsociallogin.idms.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Controller
public class SsoController {

    @SneakyThrows
    @GetMapping("/sso")
    public void home(@RequestParam String redirectTo, HttpSession httpSession,
                     HttpServletRequest request, HttpServletResponse response) {
        log.info("Processing session ID: {}", httpSession.getId());

        var cookieMap = Stream.of(request.getCookies())
                              .collect(Collectors.toMap(Cookie::getName, Function.identity()));

        if (!cookieMap.containsKey("idms-token")) {
            var tokenCookie = new Cookie("idms-token", "TOKEN_VALUE_123");
            tokenCookie.setSecure(true);
            tokenCookie.setHttpOnly(true);

            response.addCookie(tokenCookie);

            log.info("idms-token cookie added");
        } else {
            log.info("idms-token cookie already exists");
        }

        log.info("Redirecting to: {}", redirectTo);

        response.sendRedirect(redirectTo);
    }

}
