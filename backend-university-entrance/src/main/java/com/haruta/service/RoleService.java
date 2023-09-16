/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.haruta.service;

import com.haruta.pojo.Role;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nguye
 */
public interface RoleService {
    List<Role> getRoles();
    
     
//     Comment create(Comment banner, int recruitmentId);

    Role update(Role role);

    Boolean delete(int roleId);

    Role findRoleById(int roleId);
}
