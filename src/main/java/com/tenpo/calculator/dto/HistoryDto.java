/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tenpo.calculator.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author jemartinez
 */
@ApiModel(description = "History model information")
@Data
public class HistoryDto {
    
    @ApiModelProperty(value = "Execution api")
    @NotEmpty    
    private String api;
    @ApiModelProperty(value = "Execution parameters")
    @NotEmpty    
    private String input;
    @ApiModelProperty(value = "Date of execution")
    @NotEmpty  
    private OffsetDateTime created;
}
