/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tenpo.calculator.controller;

import com.tenpo.calculator.dto.HistoryDto;
import com.tenpo.calculator.service.HistoryApiService;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jemartinez
 */
@RestController
@RequestMapping("/operation")
public class OperationRestController {
    
    private HistoryApiService historyApiService;

    public OperationRestController(HistoryApiService historyApiService) {
        this.historyApiService = historyApiService;
    }
    
    @ApiOperation(value = "Api res para realizar la suma de 2 numeros.")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/sum")
    public ResponseEntity<Double> sum(@RequestParam(name = "numberOne") BigDecimal numberOne,
            @RequestParam(name = "numberTwo") BigDecimal numberTwo){
        
        double sum = numberOne.add(numberTwo).doubleValue();
        
        HistoryDto historyDto = new HistoryDto();
        historyDto.setApi("/operation/sum");
        historyDto.setInput(String.format("Input number one %s and number two %s", 
                String.valueOf(numberOne), String.valueOf(numberTwo)));
        historyDto.setCreated(OffsetDateTime.now());
        //registrar operación
        historyApiService.createHistory(historyDto);
        
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }
    
}
