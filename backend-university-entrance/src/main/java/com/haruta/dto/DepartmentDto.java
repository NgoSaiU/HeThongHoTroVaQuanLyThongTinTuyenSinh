/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.dto;

import lombok.Data;

/**
 *
 * @author HP
 */

@Data
public class DepartmentDto {

    private Integer id;
    private String name;
    private String description;
    private String website;
    private String video;
    private float averageScore;
    private Integer categoryId;

}
