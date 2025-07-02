package com.saurabh.propertymanagement.service;

import com.saurabh.propertymanagement.dto.UserDTO;
import com.saurabh.propertymanagement.exception.BusinessException;


public interface UserService {

     UserDTO registerUser(UserDTO user) throws BusinessException;
     UserDTO login(String email, String password) throws BusinessException;
}
