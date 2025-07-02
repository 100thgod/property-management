package com.saurabh.propertymanagement.service;

import com.saurabh.propertymanagement.dto.UserDTO;


public interface UserService {

     UserDTO registerUser(UserDTO user);
     UserDTO login(String email, String password);
}
