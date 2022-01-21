package cn.cst.controller.api;

import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

  @GetMapping("/{id}")
  public String getUserById(@PathVariable("id") String id) {
    return "测试" + UUID.randomUUID() + id;
  }
}
