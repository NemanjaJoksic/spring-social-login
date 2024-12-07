package org.joksin.springsociallogin.idms.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class UserController {

  @GetMapping("/api/users/me")
  public Object getMe(@AuthenticationPrincipal Object principal) {
    String username;

    if (principal instanceof User user) {
      username = user.getUsername();
    } else if (principal instanceof OAuth2User user) {
      username = user.getName();
    } else {
      username = "UNKNOWN";
    }

    return Map.of("username", username);
  }
}
