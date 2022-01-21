package cn.cst.exception;

public class CustomOauthException {
  String message;

  public CustomOauthException(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
