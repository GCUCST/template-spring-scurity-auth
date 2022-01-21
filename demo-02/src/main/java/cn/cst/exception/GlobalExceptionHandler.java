package cn.cst.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity dealEx(IllegalArgumentException e) {
    e.printStackTrace();
    System.out.println("进入...." + e.getMessage());
    return ResponseEntity.badRequest().body("参数错误");
  }
}
