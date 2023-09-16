/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.repository.impl;

import com.haruta.pojo.Banner;
import com.haruta.repository.BannerRepository;
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
 * @author nguye
 */
@Repository
@Transactional
public class BannerRepositoryImpl implements BannerRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Banner> getBanner() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Banner> b = builder.createQuery(Banner.class);
        Root root = b.from(Banner.class);
        
        b.select(root);
        
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(builder.equal(root.get("status"), "1"));
        
        b.where(predicates.toArray(Predicate[]::new));
        
        b.orderBy(builder.desc(root.get("createdDate")), builder.desc(root.get("updatedDate")));
        
        Query query = s.createQuery(b);
        return query.getResultList();
    }
    
    //them
    @Override
    public Banner save(Banner banner) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(banner);
        return banner;
    }
    //sua
    @Override
    public Banner update(Banner banner) {
        Session s = this.factory.getObject().getCurrentSession();
        s.update(banner);
        return banner;
    }
    
    //xoa
    @Override
    public Boolean delete(Banner banner) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(banner);
        return true;
    }

    //timKiemTheoIdBanner
    @Override
    public Banner findBannerById(int id) {
         Session s = this.factory.getObject().getCurrentSession();
        return s.get(Banner.class, id);
    }

    @Override
    public List<Banner> getFullBanner(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Banner> b = builder.createQuery(Banner.class);
        Root root = b.from(Banner.class);
        b.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String bannerid = params.get("bannerid");
            if (bannerid != null && !bannerid.isEmpty()) {
                predicates.add(builder.equal(root.get("id"), Double.parseDouble(bannerid)));
            }

            b.where(predicates.toArray(Predicate[]::new));

        }
        b.orderBy(builder.asc(root.get("id")));
        Query query = s.createQuery(b);
        return query.getResultList();
    }
    
}
