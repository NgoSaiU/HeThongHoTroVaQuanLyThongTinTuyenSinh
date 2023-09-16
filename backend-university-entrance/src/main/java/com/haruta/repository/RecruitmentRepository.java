/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.repository;

import com.haruta.pojo.Recruitment;
import java.util.List;

/**
 *
 * @author HP
 */
public interface RecruitmentRepository {
    List<Recruitment> getRecruitments();
    
    Recruitment save(Recruitment recruitment);

    Recruitment update(Recruitment recruitment);

    Boolean delete(Recruitment recruitment);

    Recruitment findRecruitmentById(int id);
    
}
