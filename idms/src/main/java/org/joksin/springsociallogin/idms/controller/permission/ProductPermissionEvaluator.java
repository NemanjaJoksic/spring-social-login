package org.joksin.springsociallogin.idms.controller.permission;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductPermissionEvaluator {

  public ProductPermissionEvaluator() {
    log.info("ProductPermissionEvaluator added");
  }

  public boolean hasAccessById(Authentication authentication, Long id) {
    log.info("Evaluate permissions: principal: {}, id: {}", authentication.getPrincipal(), id);
    return id == 1;
  }
}
