/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.dto;

import com.haruta.pojo.Role;
import lombok.Data;

/**
 *
 * @author HP
 */

@Data
public class UserDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String username;
    private String password;
//    private boolean active;
    private int userRoleId;


}
