package com.megaminds.order.user;

import com.megaminds.order.dto.ApiResponse;
import com.megaminds.order.dto.UserWrapperDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service",url = "${application.config.user-url}")
public interface UserClient {
    @GetMapping("/api/service/user/GetUserByUserName/{username}")
    ResponseEntity<ApiResponse<UserWrapperDto>> getUserByUsername(@PathVariable String username);

    @GetMapping("/api/service/user/GetUserByEmail/{email}")
    ResponseEntity<ApiResponse<UserWrapperDto>> getUserByEmail(@PathVariable String email);

    @GetMapping("/api/service/user/{id}")
    ResponseEntity<ApiResponse<UserWrapperDto>> getUserById(@PathVariable Long id);

    @GetMapping("/api/service/user/keycloak/{keycloakId}")
    ResponseEntity<ApiResponse<UserWrapperDto>> getUserByKeycloakId(@PathVariable String keycloakId);

    @GetMapping("/api/service/user/getProfilePictureBlobByEmail/{email}")
    ResponseEntity<String> getUserProfilePicture(@PathVariable String email);

    @PostMapping("/api/service/user/CreateUser")
    ResponseEntity<ApiResponse<UserWrapperDto>> createUser(@RequestBody UserWrapperDto userWrapper);
}
