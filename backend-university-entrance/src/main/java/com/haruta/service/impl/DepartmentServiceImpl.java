/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.service.impl;

import com.haruta.pojo.Department;
import com.haruta.repository.DepartmentRepository;
import com.haruta.service.DepartmentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nguye
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository dpmRepo;

    @Override
    public List<Department> getDpm(Map<String, String> params) {
        return this.dpmRepo.getDpm(params);
    }

    @Override
    public Department getDepartmentById(int id) {
        return this.dpmRepo.getDepartmentById(id);
    }

    @Override
    public Department update(Department department) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean delete(int departmentId) {
          Department department = dpmRepo.findDepartmentById(departmentId);
        if(department != null){
            dpmRepo.delete(department);
            return true;
        }
        return false;
    }

    @Override
    public Department findDepartmentById(int departmentId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
