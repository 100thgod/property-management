package com.saurabh.propertymanagement.service;

import com.saurabh.propertymanagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
    public PropertyDTO saveProperty(PropertyDTO propertyDTO);

    List<PropertyDTO> getAllProperties();

    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long id);

    PropertyDTO patchProperty(PropertyDTO propertyDTO, Long id);

    void deleteProperty(Long id);
}
