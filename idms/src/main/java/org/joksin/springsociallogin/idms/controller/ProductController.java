package org.joksin.springsociallogin.idms.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  @PreAuthorize("hasAuthority('OIDC_USER') and @productPermissionEvaluator.hasAccessById(authentication, #id)")
  @GetMapping("api/products/{id}")
  public String findById(@PathVariable Long id) {
    return "You have access to the product with id: " + id;
  }
}
