package io.flightinfo.api.gateway.controller;

import io.flightinfo.api.gateway.entity.UserInfo;
import io.flightinfo.api.gateway.service.UserInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserInfoController {

    private final UserInfoService service;

    public UserInfoController(UserInfoService service) {
        this.service = service;
    }


    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUserSee(@RequestBody UserInfo userInfo) {
        return new ResponseEntity<>(service.saveUser(userInfo), HttpStatus.CREATED);
    }

}
