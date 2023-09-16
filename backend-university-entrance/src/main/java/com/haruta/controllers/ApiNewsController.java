/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.controllers;

import com.haruta.dto.NewsDto;
import com.haruta.pojo.News;
import com.haruta.service.NewService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nguye
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiNewsController {
    @Autowired
    private NewService newService;
    
    
    //ok
    @GetMapping("/news")
    @CrossOrigin
    public ResponseEntity<List<News>> list(Model model, @RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.newService.getNews(params), HttpStatus.OK);
    }
    
//    @RequestMapping(path = "/news/{newsId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(path = "/news/{newsId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<News> details(@PathVariable(value = "newsId") int id) {
        return new ResponseEntity<>(this.newService.findNewsById(id), HttpStatus.OK);
    }

    @GetMapping("/recruiments/{recruimentId}/news/")
    @CrossOrigin
    public ResponseEntity<List<News>> listNewsByRec(@PathVariable(value = "recruimentId") int id) {
        return new ResponseEntity<>(this.newService.getNewsByRecruitment(id), HttpStatus.OK);
    }
    
    
 
    @GetMapping("/countnews")
    public ResponseEntity<Integer> count() {
        return new ResponseEntity<>(this.newService.countNews(), HttpStatus.OK);
    }

    
    @DeleteMapping("/news/delete/{id}/")
    @CrossOrigin
    public  ResponseEntity<?> deleteProduct (@PathVariable (value = "id") int id) {
//        return new ResponseEntity..body("You don not have permission to delete this comment");
//        return new ResponseEntity<>("Delete successfully!", HttpStatus.NO_CONTENT);
        Boolean del = this.newService.delete(id);  
        if (del) {
            return new ResponseEntity<>("Delete successfully!", HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.badRequest().body("You don not have permission to delete this comment");
        }
    }
    
    
    //ok 
    @PostMapping("/add-news/{idRecruitment}/")
    public ResponseEntity<?> createNews(@RequestBody @Valid NewsDto newsDto, @PathVariable("idRecruitment") int idRecruitment) {
        News userSaved = newService.addNews(newsDto,idRecruitment);
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
// 
    }
    
     
    //ok
    @PutMapping("/update-news/{idRecruitment}/{idNews}/")
    public ResponseEntity<?> uppdateUser(@RequestBody @Valid NewsDto newsDto,@PathVariable("idRecruitment") int idRecruitment ,@PathVariable("idNews") int newsId) {
        News newsSaved = newService.updateNews(newsDto,idRecruitment ,newsId);
        return new ResponseEntity<>(newsSaved, HttpStatus.OK);
       
// 
    }
    
}
