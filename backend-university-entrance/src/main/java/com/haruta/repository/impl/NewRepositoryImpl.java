/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.repository.impl;

import com.haruta.pojo.News;

import com.haruta.repository.NewRepository;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class NewRepositoryImpl implements NewRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<News> getNews(Map<String, String> params) {
       
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<News> m = builder.createQuery(News.class);
        Root root = m.from(News.class);
        m.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String newsid = params.get("newsid");
            if (newsid != null && !newsid.isEmpty()) {
                predicates.add(builder.equal(root.get("id"), Integer.parseInt(newsid)));
            }

            m.where(predicates.toArray(Predicate[]::new));

        }
        m.orderBy(builder.asc(root.get("id")));
        Query query = s.createQuery(m);
        return query.getResultList();
    }

    @Override
    public List<News> getNewsByRecruitment(int recruitmentId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From News Where recruitmentId.id=:id");//can phai sua lai
        q.setParameter("id", recruitmentId); //recruitment_id

//        javax.persistence.Query q = s.createQuery("News.findByCId");
        return q.getResultList();

    }

    @Override
    public int countNews() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM News");
        return Integer.parseInt(q.getSingleResult().toString());

    }

    @Override
    public News save(News news) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(news);
        return news;
    }

    @Override
    public News update(News news) {
        Session s = this.factory.getObject().getCurrentSession();
        s.update(news);
        return news;
    }

    @Override
    public Boolean delete(News news) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(news);
        return true;
    }

    @Override
    public News findNewsById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(News.class, id);
    }

}
