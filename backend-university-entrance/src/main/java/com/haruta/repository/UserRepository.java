/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.repository;

import com.haruta.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nguye
 */
public interface UserRepository {

    List<User> getUsers(Map<String, String> params);

    int countUser();

    boolean addOrUpdateUser(User u);

    User addUser(User user);

    User getUserByUsername(String username);

    boolean authUser(String username, String password);

    User post(User post);
    
    User save(User user);

    User update(User user);

    Boolean delete(User user);

    User findUserById(int id);

}
