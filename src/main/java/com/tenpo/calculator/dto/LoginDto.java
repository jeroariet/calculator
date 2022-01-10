/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tenpo.calculator.dto;

import lombok.Data;

/**
 *
 * @author jemartinez
 */
@Data
public class LoginDto {
    private String userOrEmail;
    private String password;
}
