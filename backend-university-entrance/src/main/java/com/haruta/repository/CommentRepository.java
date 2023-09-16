/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.haruta.repository;

import com.haruta.pojo.Comment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nguye
 */
public interface CommentRepository {
    List<Comment> countCmtByMonth(Map<String, String> params);
    int countComment();
    
    List<Comment> getComments(Map<String, String> params);
    
     List<Comment> getCommentsByNews (int newsId);
     
     Comment addComment(Comment c);
     
    
    
    Comment save(Comment comment);

    Comment update(Comment comment);

    Boolean delete(Comment comment);

    Comment findCommentById(int id);
}
