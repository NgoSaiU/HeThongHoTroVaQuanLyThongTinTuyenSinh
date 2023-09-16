/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.haruta.repository;

import com.haruta.pojo.Major;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nguye
 */
public interface MajorRepository {
    List<Major> getMajors(Map<String, String> params);
}
