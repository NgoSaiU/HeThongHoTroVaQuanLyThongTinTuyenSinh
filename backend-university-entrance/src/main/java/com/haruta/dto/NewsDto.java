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
public class NewsDto {

    private Integer id;
    private String title;
    private String content;
    private Date createdDate;
    private Date updatedDate;
    private short status;
    private Integer recruitmentId;
}
