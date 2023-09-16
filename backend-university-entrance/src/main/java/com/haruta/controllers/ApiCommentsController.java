/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.controllers;

import com.haruta.dto.CommentDto;
import com.haruta.pojo.Comment;
import com.haruta.service.CommentService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiCommentsController {
    
    @Autowired
    private CommentService commentService;
    
    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> list(Model model, @RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.commentService.getCommets(params), HttpStatus.OK);
    }
    
    //ok
    @GetMapping("/comment_news/{newsId}/")
    @CrossOrigin
    public ResponseEntity<List<Comment>> listNewsByRec(@PathVariable(value = "newsId") int id) {
        return new ResponseEntity<>(this.commentService.getCommentsByNews(id), HttpStatus.OK);
    }

    
    @GetMapping("/countcomments")
    public ResponseEntity<Integer> count() {
        return new ResponseEntity<>(this.commentService.countComment(), HttpStatus.OK);
    }
    
    //them comment
    //lỗi
    @PostMapping(path="/comments/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        Comment c = this.commentService.addComment(comment);
        
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
    
    
     @PostMapping("/add-comment/{idNews}/{userId}/")
    public ResponseEntity<?> createComment(@RequestBody @Valid CommentDto commentDto, @PathVariable("idNews") int idNews, @PathVariable("userId") int idUser) {
        Comment commentSaved = commentService.createComment(commentDto, idNews,idUser);
        return new ResponseEntity<>(commentSaved, HttpStatus.CREATED);
// 
    }
    
    
    @DeleteMapping("/comments/delete/{id}/")
    @CrossOrigin
    public  ResponseEntity<?> deleteProduct (@PathVariable (value = "id") int id) {
//        return new ResponseEntity..body("You don not have permission to delete this comment");
//        return new ResponseEntity<>("Delete successfully!", HttpStatus.NO_CONTENT);
        Boolean del = this.commentService.delete(id);  
        if (del) {
            return new ResponseEntity<>("Delete successfully!", HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.badRequest().body("You don not have permission to delete this comment");
        }
    }
    
    
    
    
}
