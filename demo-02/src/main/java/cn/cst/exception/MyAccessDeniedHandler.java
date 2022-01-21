package cn.cst.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

// 没有权限  走这个方法
public class MyAccessDeniedHandler implements AccessDeniedHandler {
  @Override
  public void handle(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      AccessDeniedException e)
      throws IOException, ServletException {
    Map map = new HashMap();
    map.put("errorauth", "400");
    map.put("message", e.getMessage());
    map.put("path", httpServletRequest.getServletPath());
    map.put("timestamp", String.valueOf(new Date().getTime()));
    httpServletResponse.setContentType("application/json");
    httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    try {
      ObjectMapper mapper = new ObjectMapper();
      mapper.writeValue(httpServletResponse.getOutputStream(), map);
    } catch (Exception e1) {
      throw new ServletException();
    }
  }
}
