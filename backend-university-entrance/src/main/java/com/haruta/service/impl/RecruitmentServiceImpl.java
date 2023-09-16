    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.service.impl;

import com.haruta.pojo.Recruitment;
import com.haruta.repository.RecruitmentRepository;
import com.haruta.service.RecruitmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    @Autowired
    private RecruitmentRepository recruitmentRepo;
    
    @Override
    public List<Recruitment> getRecruitments() {

        return this.recruitmentRepo.getRecruitments(); 

    }

    @Override
    public Recruitment update(Recruitment recruitment) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean delete(int recruitmentId) {
         Recruitment recruitment = recruitmentRepo.findRecruitmentById(recruitmentId);
        if(recruitment != null){
            recruitmentRepo.delete(recruitment);
            return true;
        }
        return false;
    }

    @Override
    public Recruitment findRecruitmentById(int recruitmentId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
