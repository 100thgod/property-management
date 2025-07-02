package com.saurabh.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorDTO {
    private Double num1;
    @JsonProperty("num22")
    private Double num2;
}
