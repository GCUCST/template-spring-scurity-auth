package cn.cst.filter;

import java.io.IOException;
import java.rmi.AccessException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

// 这个可以用来处理
public class LoginAuthenticationFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      FilterChain filterChain)
      throws ServletException, IOException {
    System.out.println("LoginAuthenticationFilter:调用这个过滤器 ....");
    if (httpServletRequest.getRequestURI().equals("/hid")) {
      throw new AccessException("不能进来哈哈哈");
    }
    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }
}
