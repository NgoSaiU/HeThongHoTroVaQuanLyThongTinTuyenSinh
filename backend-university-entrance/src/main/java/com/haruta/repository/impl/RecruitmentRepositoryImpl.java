/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.repository.impl;

import com.haruta.pojo.Recruitment;
import com.haruta.repository.RecruitmentRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository
@Transactional
public class RecruitmentRepositoryImpl implements RecruitmentRepository{
    
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Recruitment> getRecruitments() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Recruitment");
        
        return q.getResultList();
    }

    @Override
    public Recruitment save(Recruitment recruitment) {
       
        Session s = this.factory.getObject().getCurrentSession();
        s.save(recruitment);
        return recruitment;
    }

    @Override
    public Recruitment update(Recruitment recruitment) {
          Session s = this.factory.getObject().getCurrentSession();
        s.update(recruitment);
        return recruitment;
    }

    @Override
    public Boolean delete(Recruitment recruitment) {
          Session s = this.factory.getObject().getCurrentSession();
        s.delete(recruitment);
        return true;
    }

    @Override
    public Recruitment findRecruitmentById(int id) {
          Session s = this.factory.getObject().getCurrentSession();
        return s.get(Recruitment.class, id);
    }
    
}
