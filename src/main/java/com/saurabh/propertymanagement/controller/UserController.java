package com.saurabh.propertymanagement.controller;

import com.saurabh.propertymanagement.dto.UserDTO;
import com.saurabh.propertymanagement.exception.BusinessException;
import com.saurabh.propertymanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user/")
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userDTO) throws BusinessException {
        return new ResponseEntity<>(userService.registerUser(userDTO), HttpStatus.CREATED);
    }

   @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@Valid @RequestBody UserDTO userDTO) throws BusinessException {

        return new ResponseEntity<>(userService.login(userDTO.getOwnerEmail(), userDTO.getPassword()), HttpStatus.OK);
    }
}
