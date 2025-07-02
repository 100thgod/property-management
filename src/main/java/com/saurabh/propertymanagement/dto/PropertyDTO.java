package com.saurabh.propertymanagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PropertyDTO {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String address;
}
