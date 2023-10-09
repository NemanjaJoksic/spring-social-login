package org.joksin.springsociallogin.webapp.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RestController
public class HomeController {

    @GetMapping ("/home")
    public String home(HttpServletRequest request) {

        var cookieMap = Stream.of(request.getCookies())
                              .collect(Collectors.toMap(Cookie::getName, Function.identity()));
        log.info("Cookie names: {}", cookieMap.keySet());

        var idmsTokenCookie = cookieMap.get("IDMS_TOKEN");

        if (Objects.nonNull(idmsTokenCookie)) {
            log.info("IDMS token: {}", idmsTokenCookie.getValue());
        } else {
            log.info("Missing IDMS_TOKEN cookie");
        }

        return "Web App Home Page";
    }

}
