package com.saurabh.propertymanagement.entity;

import com.saurabh.propertymanagement.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name ="USER_TABLE")
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ownerName;
    @Column(nullable = false, unique = true)
    private String ownerEmail;
    private String password;
    private String phone;

    public UserEntity(UserDTO user) {
        this.ownerName = user.getOwnerName();
        this.ownerEmail = user.getOwnerEmail();
        this.password = user.getPassword();
        this.phone = user.getPhone();

    }

    public UserDTO toDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setOwnerName(ownerName);
        userDTO.setOwnerEmail(ownerEmail);
//        userDTO.setPassword(password);
        userDTO.setPhone(phone);
        userDTO.setId(id);
        return userDTO;
    }
}
