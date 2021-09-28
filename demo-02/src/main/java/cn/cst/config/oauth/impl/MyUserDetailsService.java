package cn.cst.config.oauth.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("cst")) {
            UserDetails userDetails =
                    User.withUsername("cst")
                            .password(new BCryptPasswordEncoder().encode("123"))
                            .authorities("p1")
                            .build();
            return userDetails;
        } else return null;
    }
}