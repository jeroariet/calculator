/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tenpo.calculator.service.impl;

import com.tenpo.calculator.dto.HistoryDto;
import com.tenpo.calculator.dto.HistoryResponse;
import com.tenpo.calculator.entities.HistoryApi;
import com.tenpo.calculator.exception.ResourceNotFoundException;
import com.tenpo.calculator.repository.HistoryApiRepository;
import com.tenpo.calculator.service.HistoryApiService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author jemartinez
 */
@Service
public class HistoryApiServiceImpl implements HistoryApiService{
    
    private HistoryApiRepository historyApiRepository;

    public HistoryApiServiceImpl(HistoryApiRepository historyApiRepository) {
        this.historyApiRepository = historyApiRepository;
    }

    @Override
    public HistoryDto createHistory(HistoryDto historyDto) {
        // convert DTO to entity
        HistoryApi historyApi = mapToEntity(historyDto);
        HistoryApi newHistoryApi = historyApiRepository.save(historyApi);

        // convert entity to DTO
        HistoryDto historyResponse = mapToDTO(newHistoryApi);
        return historyResponse;
    }

    @Override
    public HistoryResponse getAllHistory(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
               : Sort.by(sortBy).descending();

       // create Pageable instance
       Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

       Page<HistoryApi> posts = historyApiRepository.findAll(pageable);

       // get content for page object
       List<HistoryApi> listOfHistory = posts.getContent();

       List<HistoryDto> content= listOfHistory.stream().map(history -> mapToDTO(history)).collect(Collectors.toList());

       HistoryResponse historyResponse = new HistoryResponse();
       historyResponse.setContent(content);
       historyResponse.setPageNo(posts.getNumber());
       historyResponse.setPageSize(posts.getSize());
       historyResponse.setTotalElements(posts.getTotalElements());
       historyResponse.setTotalPages(posts.getTotalPages());
       historyResponse.setLast(posts.isLast());

       return historyResponse;
    }
    
        // convert Entity into DTO
    private HistoryDto mapToDTO(HistoryApi historyApi){
//        HistoryDto historyDto = mapper.map(historyApi, HistoryDto.class);
        HistoryDto historyDto = new HistoryDto();
        historyDto.setApi(historyApi.getApi());
        historyDto.setInput(historyApi.getInput());
        historyDto.setCreated(historyApi.getCreated());        
        return historyDto;
    }

    // convert DTO to entity
    private HistoryApi mapToEntity(HistoryDto historyDto){
//        HistoryApi post = mapper.map(historyDto, HistoryApi.class);
        HistoryApi historyApi = new HistoryApi();
        historyApi.setApi(historyDto.getApi());
        historyApi.setInput(historyDto.getInput());
        historyApi.setCreated(historyDto.getCreated());
        return historyApi;
    }
}
