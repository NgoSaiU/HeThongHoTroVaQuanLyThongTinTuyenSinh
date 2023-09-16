/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.dto;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
public class LivestreamDto {
    private Integer id;
    private String name;
    private String description;
    private Date startDate;
    private Date startTime;
    private Integer recruitmentId;
}
