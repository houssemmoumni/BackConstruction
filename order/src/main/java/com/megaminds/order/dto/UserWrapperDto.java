package com.megaminds.order.dto;


import lombok.Data;
import org.keycloak.representations.idm.UserRepresentation;

@Data
public class UserWrapperDto {
    private UserRepresentation keycloakUser;
    private UserDto user;
    private String imageUrl;
}
