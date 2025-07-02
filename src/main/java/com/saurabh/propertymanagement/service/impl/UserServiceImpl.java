package com.saurabh.propertymanagement.service.impl;

import com.saurabh.propertymanagement.dto.UserDTO;
import com.saurabh.propertymanagement.entity.UserEntity;
import com.saurabh.propertymanagement.exception.BusinessException;
import com.saurabh.propertymanagement.exception.ErrorModel;
import com.saurabh.propertymanagement.repository.UserRepository;
import com.saurabh.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO registerUser(UserDTO user) throws BusinessException {
        Optional<UserEntity> userEntity =  userRepository.findByOwnerEmail(user.getOwnerEmail());
        if(userEntity.isPresent()){
            List<ErrorModel> errors = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel("Email already exist", "DUPLICATE_EMAIL");
            errors.add(errorModel);
            throw new BusinessException(errors);

        }else{
            return userRepository.save(new UserEntity(user)).toDTO();
        }
    }

    @Override
    public UserDTO login(String email, String password) throws BusinessException {
        Optional<UserEntity> user = userRepository.findByOwnerEmailAndPassword(email, password);
        if (user.isPresent()) {
           return user.get().toDTO();
        }else{
            List<ErrorModel> errors = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel("Incorrect Email and Password", "INVALID_LOGIN");
            errors.add(errorModel);
            throw new BusinessException(errors);
        }

    }
}
