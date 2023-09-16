/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.haruta.service;

import com.haruta.pojo.Department;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nguye
 */
public interface DepartmentService {
    List<Department> getDpm(Map<String, String> params);
    Department getDepartmentById(int id);
    
    
     
//     Comment create(Comment banner, int recruitmentId);

    Department update(Department department);

    Boolean delete(int departmentId);

    Department findDepartmentById(int departmentId);
    
}
