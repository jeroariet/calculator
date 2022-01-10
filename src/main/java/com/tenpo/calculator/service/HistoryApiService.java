/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tenpo.calculator.service;

import com.tenpo.calculator.dto.HistoryDto;
import com.tenpo.calculator.dto.HistoryResponse;

/**
 *
 * @author jemartinez
 */
public interface HistoryApiService {
    
    HistoryDto createHistory(HistoryDto historyDto);

    HistoryResponse getAllHistory(int pageNo, int pageSize, String sortBy, String sortDir);

}
