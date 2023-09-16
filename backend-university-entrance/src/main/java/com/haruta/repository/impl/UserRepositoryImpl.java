/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.repository.impl;

import com.haruta.pojo.User;
import com.haruta.repository.UserRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nguye
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SimpleDateFormat f;

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public List<User> getUsers(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<User> u = builder.createQuery(User.class);
        Root root = u.from(User.class);
        u.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String userid = params.get("userid");
            if (userid != null && !userid.isEmpty()) {
                predicates.add(builder.equal(root.get("id"), Double.parseDouble(userid)));
            }

            String username = params.get("username");
            if (username != null && !username.isEmpty()) {
                predicates.add(builder.like(root.get("username"), String.format("%%%s%%", username)));
            }

            u.where(predicates.toArray(Predicate[]::new));

        }
        u.orderBy(builder.asc(root.get("id")));
        Query query = s.createQuery(u);
        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateUser(User u) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (u.getId() == null) {
                s.save(u);
            } else {
                s.update(u);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User addUser(User user) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(user);

        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        org.hibernate.query.Query q = s.createQuery("FROM User WHERE username=:un");
        q.setParameter("un", username);
        return (User) q.getSingleResult();

    }

//     @Override
//    public User findByUsername(String username) {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createQuery("select u from User u where u.username =:username");
//        q.setParameter("username", username);
//        q.setMaxResults(1);
//        User user = null;
//        try {
//            user = (User) q.getSingleResult();
//        } catch (NoResultException e) {
//            throw new NoSuchFieldException();
//        } finally {
//            return user;
//        }
//    }
    @Override
    public boolean authUser(String username, String password) {
        User u = this.getUserByUsername(username);

        return this.passEncoder.matches(password, u.getPassword());
//        boolean t = false;
//        if (password.equals(u.getPassword())) {
//            t = true;
//        }
//        return t;

    }

    @Override
    public int countUser() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM User");
        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public User save(User user) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(user);
        return user;
    }

    @Override
    public User update(User user) {
        Session s = this.factory.getObject().getCurrentSession();
        s.update(user);
        return user;
    }

    @Override
    public Boolean delete(User user) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(user);
        return true;
    }

    @Override
    public User findUserById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(User.class, id);
    }

    @Override
    public User post(User post) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(post);
        return post;
    }

}
