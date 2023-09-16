/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.repository.impl;

import com.haruta.pojo.Comment;
import com.haruta.pojo.News;
import com.haruta.repository.CommentRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class CommentRepositoryImpl implements CommentRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public int countComment() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM Comment");
        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public List<Comment> countCmtByMonth(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Comment> c = builder.createQuery(Comment.class);
        Root root = c.from(Comment.class);
        c.select(root);

        if (params != null) {
            String m = params.get("month");
            if (m != null && !m.isEmpty()) {
//                Predicate p = builder.equal(root.get("createdDate"), Date.)
            }
        }

        c.orderBy(builder.asc(root.get("id")));
        Query query = s.createQuery(c);
        return query.getResultList();
    }

    @Override
    public List<Comment> getComments(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Comment> b = builder.createQuery(Comment.class);
        Root root = b.from(Comment.class);
        b.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String newid = params.get("newid");
            if (newid != null && !newid.isEmpty()) {
                predicates.add(builder.equal(root.get("newId"), new News(Integer.parseInt(newid))));

            }

            b.where(predicates.toArray(Predicate[]::new));

        }
        b.orderBy(builder.asc(root.get("id")));
        Query query = s.createQuery(b);
        return query.getResultList();

    }


    @Override
    public List<Comment> getCommentsByNews(int newsId) {
        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createQuery("From Comment Where new_id.id=:id");//can phai sua lai
        Query q = s.createQuery("From Comment Where newId.id=:id");//can phai sua lai
        q.setParameter("id", newsId); //recruitment_id
                                        
        
//        javax.persistence.Query q = s.createQuery("News.findByCId");

        
        return q.getResultList();
    }

    @Override
    public Comment addComment(Comment c) {
         Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(c);
            return c;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Comment save(Comment comment) {
         Session s = this.factory.getObject().getCurrentSession();
        s.save(comment);
        return comment;
    }

    @Override
    public Comment update(Comment comment) {
         Session s = this.factory.getObject().getCurrentSession();
        s.update(comment);
        return comment;
    }

    @Override
    public Boolean delete(Comment comment) {
          Session s = this.factory.getObject().getCurrentSession();
        s.delete(comment);
        return true;
    }

    @Override
    public Comment findCommentById(int id) {
         Session s = this.factory.getObject().getCurrentSession();
        return s.get(Comment.class, id);
    }

}
