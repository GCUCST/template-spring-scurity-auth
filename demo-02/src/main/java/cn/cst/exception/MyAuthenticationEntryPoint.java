package cn.cst.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

// 没有token或者token错误  走这个方法
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
  @Override
  public void commence(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException authException)
      throws ServletException {

    Map map = new HashMap();
    map.put("errorentry", "401");
    map.put("message", authException.getMessage());
    map.put("path", request.getServletPath());
    map.put("timestamp", String.valueOf(new Date().getTime()));
    response.setContentType("application/json");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    try {
      ObjectMapper mapper = new ObjectMapper();
      mapper.writeValue(response.getOutputStream(), map);
    } catch (Exception e) {
      throw new ServletException();
    }
  }
}
