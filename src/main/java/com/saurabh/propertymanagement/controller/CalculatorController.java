package com.saurabh.propertymanagement.controller;

import com.saurabh.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {
@GetMapping("/add")
    public Double addition(@RequestParam("num1") Double a, @RequestParam("num2") Double b) {
        return a + b;
    }
    @GetMapping("/sub/{num1}/{num2}")
    public Double subtraction(@PathVariable("num1") Double a,@PathVariable("num2") Double b) {

    return a-b;
    }

    @PostMapping("/mul")
    public ResponseEntity<Double> multiplication(@RequestBody CalculatorDTO calculatorDTO) {
        Double c =  calculatorDTO.getNum1() * calculatorDTO.getNum2();
        ResponseEntity<Double> responseEntity = new ResponseEntity<>(calculatorDTO.getNum1(), HttpStatus.CREATED);
        return responseEntity;
    }
}
