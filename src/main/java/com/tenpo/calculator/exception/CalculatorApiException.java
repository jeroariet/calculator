/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tenpo.calculator.exception;

import org.springframework.http.HttpStatus;

/**
 *
 * @author jemartinez
 */
public class CalculatorApiException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public CalculatorApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public CalculatorApiException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}