package cn.cst.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class HomeController {

  @GetMapping("/get1")
  @PreAuthorize("hasAuthority('p1')")
  public String getWithP1() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return "getWithP1";
  }

  @GetMapping("/get2")
  @PreAuthorize("hasAuthority('p2')")
  public String getWithP2() {
    return "getWithP2";
  }

  @GetMapping("/get")
  public String getWithoutP() {
    return "getWithoutP";
  }
}
