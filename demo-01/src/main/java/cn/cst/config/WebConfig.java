package cn.cst.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  //    @Autowired
  //    LoginInterceptor loginInterceptor;
  //
  //    @Override
  //    public void addInterceptors(InterceptorRegistry registry) {
  //
  // registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/index","/myLogin");
  //    }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/index").setViewName("index");
    registry.addViewController("/home").setViewName("home");
    registry.addViewController("/myLogin").setViewName("myLogin");
    registry.addViewController("/index_p1").setViewName("index_p1");
    registry.addViewController("/index_p2").setViewName("index_p2");
  }
}
