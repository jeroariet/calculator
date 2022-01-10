/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tenpo.calculator.service;

import com.tenpo.calculator.dto.HistoryDto;
import com.tenpo.calculator.entities.HistoryApi;
import org.mapstruct.Mapper;

/**
 *
 * @author jemartinez
 */
@Mapper(componentModel = "spring")
public interface HistoryApiMapper {
    HistoryDto historyApiToHistoryDto (HistoryApi source);
}
