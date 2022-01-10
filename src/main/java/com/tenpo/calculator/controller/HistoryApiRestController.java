/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.tenpo.calculator.controller;

import com.tenpo.calculator.dto.HistoryDto;
import com.tenpo.calculator.dto.HistoryResponse;
import com.tenpo.calculator.service.HistoryApiService;
import com.tenpo.calculator.util.AppConstants;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jemartinez
 */
@RestController
@RequestMapping("/api/history")
public class HistoryApiRestController {
    
private HistoryApiService historyApiService;

public HistoryApiRestController(HistoryApiService historyApiService) {
    this.historyApiService = historyApiService;
}

@ApiOperation(value = "Get All history REST API")
@PreAuthorize("hasRole('ADMIN')")
// get all posts rest api
@GetMapping("")
public HistoryResponse getAllPosts(
        @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
        @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
        @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
        @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
){
    return historyApiService.getAllHistory(pageNo, pageSize, sortBy, sortDir);
}
    
}
