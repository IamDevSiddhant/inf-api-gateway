package io.flightinfo.api.gateway.config;

import io.flightinfo.api.gateway.entity.UserInfo;
import io.flightinfo.api.gateway.repository.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class UserInfoUserDetailService implements UserDetailsService {

    @Autowired
    UserInfoRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("user name "+username);
        Optional<UserInfo> userInfo = repository.findByUserName(username);
        log.info("user {}",userInfo);
        return userInfo
                .map(UserInfoUserDetails::new)
                .orElseThrow(()->new RuntimeException("username not found in UserInfoUserDetaislService"));
    }
}
