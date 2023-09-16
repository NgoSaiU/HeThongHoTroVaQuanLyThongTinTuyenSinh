/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.repository.impl;

import com.haruta.pojo.Role;
import com.haruta.repository.RoleRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nguye
 */
@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Role> getRoles() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Role");
        return q.getResultList();
    }

    @Override
    public Role save(Role role) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(role);
        return role;

    }

    @Override
    public Role update(Role role) {
        Session s = this.factory.getObject().getCurrentSession();
        s.update(role);
        return role;
    }

    @Override
    public Boolean delete(Role role) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(role);
        return true;
    }

    @Override
    public Role findRoleById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Role.class, id);
    }
}
