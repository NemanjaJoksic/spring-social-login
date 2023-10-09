package org.joksin.springsociallogin.idms.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.session.SessionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@Slf4j
@RestController
@AllArgsConstructor
public class SessionController {

    private final SessionRepository<?> sessionRepository;

    @GetMapping("/api/sessions/{id}")
    public String findSessionById(@PathVariable String id) {
        String decodedId = new String(Base64.getDecoder().decode(id));

        log.info("Searching for session with ID: {}", decodedId);
        var session = sessionRepository.findById(decodedId);
        return session.getId();
    }

}
