package com.saurabh.propertymanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class BusinessException extends Exception{
    private final transient List<ErrorModel> errors;
}
