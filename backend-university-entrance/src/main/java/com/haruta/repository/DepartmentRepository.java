/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.haruta.repository;


import com.haruta.pojo.Department;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nguye
 */
public interface DepartmentRepository {
    List<Department> getDpm(Map<String, String> params);
    Department getDepartmentById(int id);
    
    
     
    Department save(Department department);

    Department update(Department department);

    Boolean delete(Department department);

    Department findDepartmentById(int id);
}
