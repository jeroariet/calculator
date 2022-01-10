/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.tenpo.calculator.repository;

import com.tenpo.calculator.entities.HistoryApi;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jemartinez
 */
public interface HistoryApiRepository extends JpaRepository<HistoryApi, Long> { 
}
