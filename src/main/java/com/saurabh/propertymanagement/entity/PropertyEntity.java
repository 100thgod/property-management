package com.saurabh.propertymanagement.entity;

import com.saurabh.propertymanagement.dto.PropertyDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name ="PROPERTY_TABLE")
public class PropertyEntity {

    public PropertyEntity() {

    }

    public PropertyEntity(PropertyDTO propertyDTO) {
        this.title = propertyDTO.getTitle();
        this.description = propertyDTO.getDescription();
        this.address = propertyDTO.getAddress();
        this.price = propertyDTO.getPrice();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PROPERTY_TITLE", nullable = false)
    private String title;
    private String description;
    private double price;
    private String address;

    public PropertyDTO toDTO() {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setTitle(this.title);
        propertyDTO.setDescription(this.description);
        propertyDTO.setAddress(this.address);
        propertyDTO.setPrice(this.price);
        propertyDTO.setId(this.id);
        return propertyDTO;
    }


}
