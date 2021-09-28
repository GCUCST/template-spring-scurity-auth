package cn.cst.config.oauth;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.http.AccessTokenRequiredException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


//这个可以用来处理  登录前的操作，比如验证码
public class LoginAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("LoginAuthenticationFilter:调用这个过滤器 ....");
        if(httpServletRequest.getParameter("code").equals("123"))
        {
            filterChain.doFilter(httpServletRequest, httpServletResponse);

        }
        else{
            Map map = new HashMap();
            map.put("code", "401");
            map.put("message", "验证码错误");
            map.put("path", httpServletRequest.getServletPath());
            map.put("timestamp", String.valueOf(new Date().getTime()));
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            try {
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(httpServletResponse.getOutputStream(), map);
            } catch (Exception e) {
                throw new ServletException();
            }
        }


    }
}
