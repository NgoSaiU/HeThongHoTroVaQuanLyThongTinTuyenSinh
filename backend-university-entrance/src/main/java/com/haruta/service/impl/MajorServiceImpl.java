/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.service.impl;

import com.haruta.pojo.Major;
import com.haruta.repository.MajorRepository;
import com.haruta.service.MajorService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nguye
 */
@Service
public class MajorServiceImpl implements MajorService{
    @Autowired
    private MajorRepository majroRepo;

    @Override
    public List<Major> getMajors(Map<String, String> params) {
        return this.majroRepo.getMajors(params);
    }
    
}
