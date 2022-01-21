package cn.cst.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailServiceImpl implements UserDetailsService {
  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    final UserDetails build =
        User.builder()
            .username("cst")
            .password(new BCryptPasswordEncoder().encode("456"))
            .authorities("p2")
            .build();
    return build;
  }
}
