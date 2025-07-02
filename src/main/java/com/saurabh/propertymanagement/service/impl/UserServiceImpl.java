package com.saurabh.propertymanagement.service.impl;

import com.saurabh.propertymanagement.dto.UserDTO;
import com.saurabh.propertymanagement.entity.UserEntity;
import com.saurabh.propertymanagement.repository.UserRepository;
import com.saurabh.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO registerUser(UserDTO user) {
        return userRepository.save(new UserEntity(user)).toDTO();
    }

    @Override
    public UserDTO login(String email, String password) {
        Optional<UserEntity> user = userRepository.findByOwnerEmail(email);
        if (user.isPresent()) {
            UserEntity userEntity = user.get();
            if (userEntity.getPassword().equals(password)) {
                return userEntity.toDTO();
            }
        }
        return null;
    }
}
