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
public class QuestionDto {
    private Integer id;
    private String content;
    private String answer;
    private Date createdDate;
    private Date answeredDate;
    private Integer userId;
    private Integer livestreamId;
    
    
}
