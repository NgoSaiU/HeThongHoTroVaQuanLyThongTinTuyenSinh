/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.service.impl;

import com.haruta.dto.CommentDto;
import com.haruta.pojo.Comment;
import com.haruta.pojo.News;
import com.haruta.pojo.User;
import com.haruta.repository.CommentRepository;
import com.haruta.repository.NewRepository;
import com.haruta.repository.UserRepository;
import com.haruta.service.CommentService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author nguye
 */
@Service
public class CommentServiceImpl implements CommentService{
    
    @Autowired
    private CommentRepository cmtRepo;
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private NewRepository newsRepository;
    
    

    @Override
    public int countComment() {
        return this.cmtRepo.countComment();
    }

    @Override
    public List<Comment> countCmtByMonth(Map<String, String> params) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Comment> getCommets(Map<String, String> params) {
        return this.cmtRepo.getComments(params); 
    }

    @Override
    public List<Comment> getCommentsByNews(int newsId) {
        return this.cmtRepo.getCommentsByNews(newsId);
    }

    @Override
    public Comment addComment(Comment c) {
        c.setCreatedDate(new Date());
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.userRepo.getUserByUsername(authentication.getName());
        c.setUserId(u);
        
        return this.cmtRepo.addComment(c);
    }

    @Override
    public Comment update(Comment comment) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean delete(int commentId) {
         Comment comment = cmtRepo.findCommentById(commentId);
        if(comment != null){
            cmtRepo.delete(comment);
            return true;
        }
        return false;
    }

    @Override
    public Comment findCommentById(int commentId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Comment createComment(CommentDto commentDto, int idNews, int idUser) {
        
        Date date=java.util.Calendar.getInstance().getTime();  
        
        News news = newsRepository.findNewsById(idNews);
        
        User user = userRepo.findUserById(idUser);
        
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setNewId(news);
        comment.setUserId(user);
        comment.setCreatedDate(date);
        comment.setFolowComment(null);
        
        this.cmtRepo.save(comment);
        return comment;
    }

}
