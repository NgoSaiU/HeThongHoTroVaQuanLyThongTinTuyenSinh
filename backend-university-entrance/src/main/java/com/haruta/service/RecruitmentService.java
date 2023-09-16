/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.service;

import com.haruta.pojo.Recruitment;
import java.util.List;

/**
 *
 * @author HP
 */
public interface RecruitmentService {
    
    List<Recruitment> getRecruitments();
    
    
//     Recruitment create(Recruitment recruitment, int recruitmentId);

    Recruitment update(Recruitment recruitment);

    Boolean delete(int recruitmentId);

    Recruitment findRecruitmentById(int recruitmentId);
    
}
