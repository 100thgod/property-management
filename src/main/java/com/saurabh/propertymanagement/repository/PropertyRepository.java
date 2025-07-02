package com.saurabh.propertymanagement.repository;


import com.saurabh.propertymanagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {

}
