package cn.cst.config.resource;

import cn.cst.exception.MyAccessDeniedHandler;
import cn.cst.exception.MyAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

  @Autowired TokenStore tokenStore;

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) {
    // 自定义资源访问认证异常，没有token，或token错误，使用MyAuthenticationEntryPoint
    resources.authenticationEntryPoint(new MyAuthenticationEntryPoint());
    resources.accessDeniedHandler(new MyAccessDeniedHandler());

    resources.resourceId("res1").tokenStore(tokenStore).stateless(true);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
        .antMatchers("/api/auth/**")
        .permitAll()
        .antMatchers("/actuator/**", "/captcha/getCaptcha", "/captcha/checkCaptcha")
        .authenticated()
        .and()
        .csrf()
        .disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // 配置一个登录前的过滤器
    http.addFilterBefore(
        new TokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
  }
}
