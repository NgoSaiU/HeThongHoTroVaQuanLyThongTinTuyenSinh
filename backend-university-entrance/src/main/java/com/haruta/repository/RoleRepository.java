/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.haruta.repository;

import com.haruta.pojo.Role;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nguye
 */
public interface RoleRepository {
    List<Role> getRoles();
    
    
    Role save(Role role);

    Role update(Role role);

    Boolean delete(Role role);

    Role findRoleById(int id);
}
