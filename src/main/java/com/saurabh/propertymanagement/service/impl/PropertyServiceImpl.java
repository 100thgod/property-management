package com.saurabh.propertymanagement.service.impl;

import com.saurabh.propertymanagement.dto.PropertyDTO;
import com.saurabh.propertymanagement.entity.PropertyEntity;
import com.saurabh.propertymanagement.repository.PropertyRepository;
import com.saurabh.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        return propertyRepository.save(new PropertyEntity(propertyDTO)).toDTO();


    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        for (PropertyEntity property :  propertyRepository.findAll()){
            propertyDTOList.add(property.toDTO());
        }
        return propertyDTOList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long id) {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(id);
        System.out.println(propertyEntity);
        if (propertyEntity.isPresent()) {
            PropertyEntity propertyEntity1 = propertyEntity.get();
            propertyEntity1.setPrice( propertyDTO.getPrice());
            propertyEntity1.setDescription(propertyDTO.getDescription());
            propertyEntity1.setAddress(propertyDTO.getAddress());
            propertyEntity1.setTitle(propertyDTO.getTitle());
            propertyEntity1.setOwnerEmail(propertyDTO.getOwnerEmail());
            propertyEntity1.setOwnerName(propertyDTO.getOwnerName());
            return propertyRepository.save(propertyEntity1).toDTO();
        }
        return null;
    }

    @Override
    public PropertyDTO patchProperty(PropertyDTO propertyDTO, Long id) {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(id);
        System.out.println(propertyEntity);
        if (propertyEntity.isPresent()) {

            PropertyEntity propertyEntity1 = propertyEntity.get();
            if(propertyDTO.getPrice()!= 0) {
                propertyEntity1.setPrice(propertyDTO.getPrice());
            }
            if (propertyDTO.getDescription() != null) {
                propertyEntity1.setDescription(propertyDTO.getDescription());
            }
            if (propertyDTO.getAddress() != null) {
                propertyEntity1.setAddress(propertyDTO.getAddress());
            }
            if (propertyDTO.getTitle()!= null) {
                propertyEntity1.setTitle(propertyDTO.getTitle());
            }
            if (propertyDTO.getOwnerEmail()!= null) {
                propertyEntity1.setOwnerEmail(propertyDTO.getOwnerEmail());
            }
            if (propertyDTO.getOwnerName()!= null) {
                propertyEntity1.setOwnerName(propertyDTO.getOwnerName());
            }
            return propertyRepository.save(propertyEntity1).toDTO();
        }

        return null;
    }

    @Override
    public void deleteProperty(Long id) {
         propertyRepository.deleteById(id);
    }
}
