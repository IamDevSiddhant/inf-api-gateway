package io.flightinfo.api.gateway.repository;


import io.flightinfo.api.gateway.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
    Optional<UserInfo> findByUserName(String userName);

}
