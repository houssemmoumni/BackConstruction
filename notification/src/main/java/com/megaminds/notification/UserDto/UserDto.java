package com.megaminds.notification.UserDto;

import lombok.Data;

@Data
public class UserDto {

        private Long id_User;
        private String login;
        private String email;
        private String firstName;
        private String lastName;
        private String role;
        private int numTel;
        private String keycloakId;
        private String imageBase64; // For base64 encoded image


}
