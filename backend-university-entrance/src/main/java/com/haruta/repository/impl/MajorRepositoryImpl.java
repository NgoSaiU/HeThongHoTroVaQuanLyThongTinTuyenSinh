/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.repository.impl;

import com.haruta.pojo.Major;
import com.haruta.repository.MajorRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class MajorRepositoryImpl implements MajorRepository{
    
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Major> getMajors(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Major> m = builder.createQuery(Major.class);
        Root root = m.from(Major.class);
        m.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String departmentid = params.get("departmentid");
            if (departmentid != null && !departmentid.isEmpty()) {
                predicates.add(builder.equal(root.get("departmentId"), Integer.parseInt(departmentid)));
            }

            m.where(predicates.toArray(Predicate[]::new));

        }
        m.orderBy(builder.asc(root.get("id")));
        Query query = s.createQuery(m);
        return query.getResultList();
    }
    
}
