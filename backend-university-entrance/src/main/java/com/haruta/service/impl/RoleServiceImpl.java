/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.service.impl;

import com.haruta.pojo.Role;
import com.haruta.repository.RoleRepository;
import com.haruta.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nguye
 */
@Service
public class RoleServiceImpl implements RoleService{
    
    @Autowired
    private RoleRepository roleRepo;

    @Override
    public List<Role> getRoles() {
        return this.roleRepo.getRoles();
    }

    @Override
    public Role update(Role role) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean delete(int roleId) {
          Role role = roleRepo.findRoleById(roleId);
        if(role != null){
            roleRepo.delete(role);
            return true;
        }
        return false;
    }

    @Override
    public Role findRoleById(int roleId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
