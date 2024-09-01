package io.flightinfo.api.gateway.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User_Details")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Id
    private String  id;
    private String userName;
    private String userEmail;
    private String phoneNumber;
    private String role;
    private String passWord;
    private String address;
    private String city;
    private String state;
    private String country;
}
