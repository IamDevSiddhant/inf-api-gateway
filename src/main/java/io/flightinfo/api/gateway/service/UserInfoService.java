package io.flightinfo.api.gateway.service;


import io.flightinfo.api.gateway.entity.UserInfo;
import org.springframework.stereotype.Component;

@Component
public interface UserInfoService {
    UserInfo saveUser(UserInfo userInfo);
}
