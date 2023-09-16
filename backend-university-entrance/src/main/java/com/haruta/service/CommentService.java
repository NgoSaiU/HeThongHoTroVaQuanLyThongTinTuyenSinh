/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.haruta.service;

import com.haruta.dto.CommentDto;
import com.haruta.pojo.Comment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nguye
 */
public interface CommentService {
    List<Comment> countCmtByMonth(Map<String, String> params);
    int countComment();
    
    
    List<Comment> getCommets(Map<String, String> params);
    List<Comment> getCommentsByNews (int newsId);
    
    Comment addComment(Comment c);
    
    
     Comment createComment(CommentDto commentDto, int idNews, int idUser);

    Comment update(Comment comment);

    Boolean delete(int commentId);

    Comment findCommentById(int commentId);
}
