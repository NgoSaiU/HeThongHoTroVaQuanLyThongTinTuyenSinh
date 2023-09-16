/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.repository.impl;

import com.haruta.pojo.Livestream;
import com.haruta.repository.LiveStreamRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
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
public class LiveStreamRepositoryImpl implements LiveStreamRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Livestream> getLivestreams() {
         Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Livestream> b = builder.createQuery(Livestream.class);
        Root root = b.from(Livestream.class);
        
        b.select(root);
        
        List<Predicate> predicates = new ArrayList<>();

//        predicates.add(builder.equal(root.get("status"), "1"));
        
        b.where(predicates.toArray(Predicate[]::new));
        
//        b.orderBy(builder.desc(root.get("createdDate")), builder.desc(root.get("updatedDate")));
        
        Query query = s.createQuery(b);
        return query.getResultList();
    }

    @Override
    public List<Livestream> getFullLivestreams(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Livestream> b = builder.createQuery(Livestream.class);
        Root root = b.from(Livestream.class);
        b.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String livestreamid = params.get("livestreamid");
            if (livestreamid != null && !livestreamid.isEmpty()) {
                predicates.add(builder.equal(root.get("id"), Integer.parseInt(livestreamid)));
            }

            b.where(predicates.toArray(Predicate[]::new));

        }
        b.orderBy(builder.asc(root.get("id")));
        Query query = s.createQuery(b);
        return query.getResultList();
    }

    @Override
    public Livestream save(Livestream livestream) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(livestream);
        return livestream;
    }

    @Override
    public Livestream update(Livestream livestream) {
        Session s = this.factory.getObject().getCurrentSession();
        s.update(livestream);
        return livestream;

    }

    @Override
    public Boolean delete(Livestream livestream) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(livestream);
        return true;
    }

    @Override
    public Livestream findLivestreamById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Livestream.class, id);
    }

}
