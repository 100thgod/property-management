package com.saurabh.propertymanagement.controller;

import com.saurabh.propertymanagement.dto.PropertyDTO;
import com.saurabh.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/property/")
public class PropertyController {
    private PropertyService propertyService;
    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/hello")
    public PropertyDTO hello() {
        return new PropertyDTO();
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
        return new ResponseEntity<>(propertyService.saveProperty(propertyDTO), HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        return new ResponseEntity<>(propertyService.getAllProperties(), HttpStatus.OK);
    }

    @PutMapping("/properties/{id}")
    public ResponseEntity<PropertyDTO> updateProperty(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO) {
        return new ResponseEntity<>(propertyService.updateProperty(propertyDTO, id), HttpStatus.ACCEPTED);
    }
    @PatchMapping("/properties/{id}")
    public ResponseEntity<PropertyDTO> patchProperty(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO) {
        return new ResponseEntity<>(propertyService.patchProperty(propertyDTO, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/properties/{id}")
    public ResponseEntity<PropertyDTO> deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
