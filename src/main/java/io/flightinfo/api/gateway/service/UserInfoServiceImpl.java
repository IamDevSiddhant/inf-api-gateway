package io.flightinfo.api.gateway.service;

import io.flightinfo.api.gateway.entity.UserInfo;
import io.flightinfo.api.gateway.repository.UserInfoRepository;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Encoder;
import java.util.UUID;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {


    private final PasswordEncoder encoder;
    private final UserInfoRepository userInfoRepository;

    //@Autowired @Qualifier("encoder")
    public UserInfoServiceImpl(PasswordEncoder encoder, UserInfoRepository userInfoRepository) {
        this.encoder = encoder;
        this.userInfoRepository = userInfoRepository;
    }


    @Transactional
    public UserInfo saveUser(@NonNull UserInfo userInfo) {
        log.info("saving user");
        var randomId = UUID.randomUUID().toString();
        userInfo.setId(randomId);
        String encodedPassword = encoder.encode(userInfo.getPassWord());
        userInfo.setPassWord(encodedPassword);
        return userInfoRepository.save(userInfo);
    }
}
